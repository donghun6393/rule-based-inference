package org.DroolsEngine;

//import org.kie.api.KieServices;
//import org.kie.api.builder.KieBuilder;
//import org.kie.api.builder.KieFileSystem;
//import org.kie.api.builder.KieRepository;
//import org.kie.api.builder.ReleaseId;
//import org.kie.api.runtime.KieContainer;
//import org.kie.internal.io.ResourceFactory;
import org.kie.api.runtime.KieSession;


public class DroolsController {
	
	private static KieSession kieSession;
	
	public static DroolsEngineOutput inputForDrools(DroolsEngineInput input) {
		
		/*
		KieServices kieServices = KieServices.Factory.get();
		
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		String xlsList[] = new String[] {
				"rules/locationAssign.xlsx",
				"rules/locationTypeAssign.xlsx",
				"rules/taskAssign.xlsx",
				"rules/taskTypeAssign.xlsx",
				"rules/location-task-Weight.xlsx",
				"rules/location-task-pose-Weight.xlsx",
				"rules/riskLevel.xlsx"
		};
		
		for(int i=0 ; i< xlsList.length; i++) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(xlsList[i]));
        }
		
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		
		KieRepository kieRepository = kieServices.getRepository();
		
		ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
		KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);
		
		KieSession kieSession = kieContainer.newKieSession();
		*/
		
		kieSession = DroolsConfig.DroolsEngine();

		kieSession.insert(input);
		kieSession.fireAllRules();
		
		DroolsEngineThroughput throughput = new DroolsEngineThroughput();
		
		throughput.setLocationName(input.getLocationName());
		throughput.setTaskName(input.getTaskName());
		throughput.setPoseName(input.getPoseName());
		
		throughput.setLocationType(input.getLocationType());
		throughput.setTaskType(input.getTaskType());
		
		throughput.setTimeStamp(input.getTimeStamp());
		throughput.setModelId(input.getModelId());
		throughput.setWorkerId(input.getWorkerId());
		throughput.setWorkerStencilId(input.getWorkerStencilId());
		
		kieSession.insert(throughput);
		kieSession.fireAllRules();

		DroolsEngineOutput riskLevel = new DroolsEngineOutput();
		
		riskLevel.setLocationName(throughput.getLocationName());
		riskLevel.setTaskName(throughput.getTaskName());
		riskLevel.setPoseName(throughput.getPoseName());
	
		riskLevel.setLocationNtaskWeight(throughput.getLocationNtaskWeight());
		riskLevel.setPoseWeight(throughput.getPoseWeight());
		riskLevel.setResultOfCalc(throughput.getLocationNtaskWeight(), throughput.getPoseWeight());//, throughput.getTaskWeight());
		
		riskLevel.setTimeStamp(throughput.getTimeStamp());
		riskLevel.setModelId(throughput.getModelId());
		riskLevel.setWorkerId(throughput.getWorkerId());
		riskLevel.setWorkerStencilId(throughput.getWorkerStencilId());

		kieSession.insert(riskLevel);
		kieSession.fireAllRules();
		
		if (riskLevel.locationName == null) {
			riskLevel.setLocationName("Safe location");
		}
		
		if (riskLevel.taskName == null) {
			riskLevel.setTaskName("Safe workspace");
		}

		return riskLevel;
	}
}
