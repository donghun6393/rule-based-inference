package org.DroolsEngine;

public class DroolsEngineInput {
	
	public String timeStamp;
	public String workerId;
	public String workerStencilId;
	public String modelId;
	
	public double positionX;
	public double positionY;
	public String poseName;

	public String locationName;
	public String taskName;
	public String locationType;
	public String taskType;

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
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public String getPoseName() {
		return poseName;
	}
	public void setPoseName(String poseName) {
		this.poseName = poseName;
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
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
}
