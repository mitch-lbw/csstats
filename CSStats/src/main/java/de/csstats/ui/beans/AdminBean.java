package de.csstats.ui.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import de.csstats.service.LogfileService;

@ManagedBean
@ViewScoped
public class AdminBean {

	@ManagedProperty("#{logfileService}")
	private LogfileService logfileService;

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " uploaded");
		try {
			boolean success = this.logfileService.uploadFile(event.getFile().getFileName(),
					event.getFile().getContents());
			if (!success) {
				message = new FacesMessage("Warn",
						event.getFile().getFileName() + " already exists, file not uploaded");
			}
		} catch (Exception e) {
			message = new FacesMessage("Error",
					"Error uploading file " + event.getFile().getFileName() + ": " + e.getMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void groupUploadFiles() {
		this.logfileService.groupLogfiles();
	}

	public LogfileService getLogfileService() {
		return logfileService;
	}

	public void setLogfileService(LogfileService logfileService) {
		this.logfileService = logfileService;
	}

}
