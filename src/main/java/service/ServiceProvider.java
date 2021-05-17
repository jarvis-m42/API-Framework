package service;

import service.resreq.ResReqService;

public class ServiceProvider {

	public ResReqService resreqService() {

		return new ResReqService();
	}
}
