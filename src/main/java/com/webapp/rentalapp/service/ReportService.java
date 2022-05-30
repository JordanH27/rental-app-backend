package com.webapp.rentalapp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.webapp.rentalapp.model.Invoice;
import com.webapp.rentalapp.model.InvoiceDetails;
import com.webapp.rentalapp.model.Property;
import com.webapp.rentalapp.model.PropertyTenant;
import com.webapp.rentalapp.model.Tenant;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private PropertyService propertyService;
	private InvoiceService invoiceService;
	private TenantService tenantService;
	private PropertyTenantService propertyTenantService;
	private EmailSenderService senderService;
	private List<InvoiceDetails> invoiceDetailsList;

	public ReportService(InvoiceService invoiceService, PropertyService propertyService, TenantService tenantService,
			PropertyTenantService propertyTenantService, List<InvoiceDetails> invoiceDetailsList, EmailSenderService senderService) {
		this.invoiceService = invoiceService;
		this.propertyService = propertyService;
		this.tenantService = tenantService;
		this.propertyTenantService = propertyTenantService;
		this.invoiceDetailsList = invoiceDetailsList;
		this.senderService = senderService;
	}

	public String exportReport(String reportFormat) throws FileNotFoundException, JRException, MessagingException {
		List<Invoice> invoices = invoiceService.findAllInvoices();

		for (int i = 0; i < invoices.size(); i++) {
			Invoice invoice = new Invoice();
			invoice = invoices.get(i);
			
			if(invoice.getDate_issued().equals("")) {
				PropertyTenant propertyTenant = propertyTenantService.findPropertyTenantById(invoice.getPropertyTenantID());
				Property property = propertyService.findPropertyById(propertyTenant.getPropertyID());
				Tenant tenant = tenantService.findTenantById(propertyTenant.getTenantID());
				
				if(!property.isElectricity_prepaid()) {
					invoice.setElectricity_cost(0);
				}
				
				if(!property.isWater_prepaid()) {
					invoice.setWater_cost(0);
				}
				
				InvoiceDetails invoiceDetails = new InvoiceDetails(invoice.getInvoiceID(), invoice.getElectricity_cost(), invoice.getRent(),
						invoice.getWater_cost(), property.getAddressLine1(), tenant.getFirstName(), tenant.getLastName());
				
				invoiceDetailsList.add(invoiceDetails);
				LocalDate now = LocalDate.now();  
				String date = now.toString();
				
				// Load file and compile it
				File file = ResourceUtils.getFile("C:\\Users\\jorda\\eclipse-workspace\\RentalApp\\src\\main\\resources\\employees.jrxml");
				JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
				JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceDetailsList);
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("createdBy", "Jordan Harri");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

				if (reportFormat.equalsIgnoreCase("pdf")) {
					JasperExportManager.exportReportToPdfFile(jasperPrint,
							"C:\\Users\\jorda\\Desktop\\Reports" + "\\Invoice_" + tenant.getFirstName() + "_" + tenant.getLastName() + "_" + date + ".pdf");
				}
				
				//send the invoice as an email
				senderService.sendMailWithAttachment(tenant.getEmail(),
						"Rental Invoice",
						"Good afternoon, please see the invoice attached below.",
						"C:\\Users\\jorda\\Desktop\\Reports" + "\\Invoice_" + tenant.getFirstName() + "_" + tenant.getLastName() + "_" + date + ".pdf");
				
				invoiceDetailsList.remove(invoiceDetails);
				invoice.setDate_issued(date);
				invoiceService.updateInvoice(invoice);
			}
			
			
			
		}

		return "Invoice generated and email sent";
	}
}
