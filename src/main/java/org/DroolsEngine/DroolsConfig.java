package org.DroolsEngine;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsConfig {

	public static KieSession DroolsEngine() {

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

		for (int i = 0; i < xlsList.length; i++) {
			kieFileSystem.write(ResourceFactory.newClassPathResource(xlsList[i]));
		}

		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();

		KieRepository kieRepository = kieServices.getRepository();

		ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
		KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

		KieSession kieSession = kieContainer.newKieSession();

		return kieSession;
	}
}
