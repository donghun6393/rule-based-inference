package org.DroolsEngine;

public class DroolsEngineOutput {
	
	
	public String timeStamp;
	public String workerId;
	public String workerStencilId;
	public String modelId;
	
	public String locationName;
	public String taskName;
	public String poseName;
	
	private double resultOfCalc;
	private String riskLevel;
	
	public double locationNtaskWeight;
//	private double locationWeight;
//	private double taskWeight;
	private double poseWeight;
	
	
	
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getWorkerStencilId() {
		return workerStencilId;
	}
	public void setWorkerStencilId(String workerStencilId) {
		this.workerStencilId = workerStencilId;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public double getLocationNtaskWeight() {
		return locationNtaskWeight;
	}
	public void setLocationNtaskWeight(double locationNtaskWeight) {
		this.locationNtaskWeight = locationNtaskWeight;
	}
		
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getPoseName() {
		return poseName;
	}
	public void setPoseName(String poseName) {
		this.poseName = poseName;
	}
	public double getResultOfCalc() {
		return resultOfCalc;
	}
	public void setResultOfCalc(double a, double b) {
		this.resultOfCalc = a * b;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	/*
	public double getLocationWeight() {
		return locationWeight;
	}
	public void setLocationWeight(double locationWeight) {
		this.locationWeight = locationWeight;
	}
	public double getTaskWeight() {
		return taskWeight;
	}
	public void setTaskWeight(double taskWeight) {
		this.taskWeight = taskWeight;
	}
	*/
	public double getPoseWeight() {
		return poseWeight;
	}
	public void setPoseWeight(double poseWeight) {
		this.poseWeight = poseWeight;
	}
	
	

}
