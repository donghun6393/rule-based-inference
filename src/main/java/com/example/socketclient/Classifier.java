package com.example.socketclient;


import org.DroolsEngine.DroolsApp;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class Classifier{
    private String []classes = {"WALKING", "WALKING_UPSTAIRS", "WALKING_DOWNSTAIRS", "SITTING", "STANDING", "LAYING"};
    private Preprocessing preprocessing;

    Classifier(){
        init();
    }

    public void init() {

    }

    public void predict(Preprocessing preprocessing) throws Exception {
        String simpleMlp = new ClassPathResource("mymodel.h5").getFile().getPath();
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);
        INDArray features = Nd4j.create(preprocessing.getOutputMatrix());
        int[] prediction = model.predict(features);

        String SERVER_URL = "http://localhost:1337/";
        String SEND_URL = "http://rnd.dexta.kr:34801";
        String posture = classes[prediction[0]];
    	
    	DroolsApp.executeInferenceEngine(SERVER_URL,SEND_URL, posture);

        //System.out.println(classes[prediction[0]]);
    }


}
