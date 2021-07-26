package io.api.CoronavirusTracker.models;

public class CoronavirusDataEntity {

	private boolean error;
	private float statusCode;
	private String message;
	Data data;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public float getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(float statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "CoronavirusDataEntity [error=" + error + ", statusCode=" + statusCode + ", message=" + message + "]";
	}
	
}
