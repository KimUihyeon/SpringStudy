package com.home.pwApp.dto;

public class BoardDTO {
	private int id;
	private String title;
	private int groupId;
	private String context;
	private String contextId;
	private String contextPw;
	
	private DirectoryDTO directoryDTO;
	public DirectoryDTO getDirectoryDTO() {
		return directoryDTO;
	}
	public void setDirectoryDTO(DirectoryDTO directoryDTO) {
		this.directoryDTO = directoryDTO;
	}
	public String getContextId() {
		return contextId;
	}
	public void setContextId(String contextId) {
		this.contextId = contextId;
	}
	public String getContextPw() {
		return contextPw;
	}
	public void setContextPw(String contextPw) {
		this.contextPw = contextPw;
	}

	private String etc;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	@Override
	public String toString() {

		return getTitle() +"||"+ getContext() +"||"+ getId();
	}
	
}
