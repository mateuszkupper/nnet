package nl;

import java.util.ArrayList;
import java.util.List;

public class test {
	static Layer input = new Layer(2);
	static Layer layer1 = new Layer(500);
	static Layer layer2 = new Layer(700);
	static Layer layer3 = new Layer(500);		
	static Layer layer4 = new Layer(1);
	
	public static void main(String[] args) {
		List<Double> inputs = new ArrayList<Double>();
		inputs.add((double) 1);
		inputs.add((double) 2);

		List<Double> inputsback1 = new ArrayList<Double>();
		inputsback1.add((double) 1);		
		train(inputs, inputsback1);

		//---------------------------------------------------------------------
		
		List<Double> inputs3 = new ArrayList<Double>();
		inputs3.add((double) 1);
		inputs3.add((double) 5);				
		
		List<Double> inputstarget = new ArrayList<Double>();
		inputstarget.add((double) 4);	
		
		trainTest(inputs3, inputstarget);
		
		for(Neuron neuron : layer4.getNeurons()){
			System.out.println(neuron.getV());
		}

		//---------------------------------------------------------------------
		
		List<Double> inputs6 = new ArrayList<Double>();
		inputs6.add((double) 2);
		inputs6.add((double) 2);		
		
		
		List<Double> inputstarget6 = new ArrayList<Double>();
		inputstarget6.add((double) 2);		
		
		trainTest(inputs6, inputstarget6);
		
		for(Neuron neuron : layer4.getNeurons()){
			System.out.println(neuron.getV());
		}		
		
		//---------------------------------------------------------------------
		
		List<Double> inputs7 = new ArrayList<Double>();
		inputs7.add((double) 10);
		inputs7.add((double) 10);			
		
		List<Double> inputstarget7 = new ArrayList<Double>();
		inputstarget7.add((double) 18);		

		trainTest(inputs7, inputstarget7);
		
		for(Neuron neuron : layer4.getNeurons()){
			System.out.println(neuron.getV());
		}				
		
		
		//---------------------------------------------------------------------
		
		List<Double> inputs8 = new ArrayList<Double>();
		inputs8.add((double) 2);
		inputs8.add((double) 4);			
		
		List<Double> inputstarget8 = new ArrayList<Double>();
		inputstarget8.add((double) 4);		

		trainTest(inputs8, inputstarget8);
		
		for(Neuron neuron : layer4.getNeurons()){
			System.out.println(neuron.getV());
		}				
		
		
		//---------------------------------------------------------------------		
		List<Double> inputsTest = new ArrayList<Double>();
		inputsTest.add((double) 1);
		inputsTest.add((double) 1);		
		input.activateInput(inputsTest);		
		layer1.activateTest(input);		
		layer2.activateTest(layer1);
		layer3.activateTest(layer2);
		layer4.activateTest(layer3);
		
		for(Neuron neuron : layer4.getNeurons()){
			System.out.println(neuron.getV());
		}
	}
	
	public static void train(List<Double> inputs, List<Double> output) {	
		input.activateInput(inputs);
		layer1.activate(input);
		layer2.activate(layer1);
		layer3.activate(layer2);			
		layer4.activate(layer3);		
		layer4.backpropagate(output);
	}
	
	public static void trainTest(List<Double> inputs, List<Double> output) {	
		input.activateInput(inputs);
		layer1.activateTest(input);
		layer2.activateTest(layer1);
		layer3.activateTest(layer2);			
		layer4.activateTest(layer3);		
		layer4.backpropagate(output);
	}	

}
