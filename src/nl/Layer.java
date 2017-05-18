package nl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Layer {
	private List<Neuron> neurons;

	public Layer(int numOfNeurons) {
		neurons = new ArrayList<Neuron>();
		for(int i = 0; i<numOfNeurons; i++) {
			neurons.add(new Neuron());
		}
	}
	
	public void activate(Layer belowLayer) {
		for(Neuron neuron : neurons) {
			neuron.activate(belowLayer);
		}
	}
	
	public void activateTest(Layer belowLayer) {
		for(Neuron neuron : neurons) {
			neuron.activateTest(belowLayer);
		}
	}	
	
	public void activateInput(List<Double> values) {
		int i = 0;
		for(Neuron neuron : neurons) {
			neuron.setV(values.get(i));
			i++;
		}		
	}
	
	public void backpropagate(List<Double> targetValues) {
		int neuronNo=0;
		for(Neuron neuron : neurons) {
			double error = targetValues.get(neuronNo) - neuron.getV();
			int numOfWs = neuron.getW().size();
			Map<Neuron, Double> newW = new HashMap<Neuron, Double>();
			Iterator<Entry<Neuron, Double>> it = neuron.getW().entrySet().iterator();
			double errorPerW = error/numOfWs;
		    while (it.hasNext()) {
//		    	Map.Entry singleW = (Map.Entry)it.next();
//				if(Wno==numOfWs-1){
//					Double sumOfWs = (double) 0;
//					Iterator<Entry<Neuron, Double>> itWs = newW.entrySet().iterator();
//					while (itWs.hasNext()) {
//						Map.Entry singleNewW = (Map.Entry)itWs.next();
//						Double x = ((Neuron) singleNewW.getKey()).getV();
//						sumOfWs+=(Double)singleNewW.getValue()*x;
//					}
//					
//					Double finalW = (targetValues.get(neuronNo) - sumOfWs)/((Neuron) singleW.getKey()).getV();
//					newW.put((Neuron) singleW.getKey(), finalW);
//				} else {
//					Random r = new Random();					
//					Double newWValue = 0 + 2/numOfWs * r.nextDouble();
//					newW.put((Neuron) singleW.getKey(), newWValue);
//				}
		    	Map.Entry singleW = (Map.Entry)it.next();
		    	double addToW = errorPerW/((Neuron)singleW.getKey()).getV()/2.0;
		    	double newWValue = (Double)singleW.getValue() + addToW;
		    	newW.put((Neuron) singleW.getKey(), newWValue);
		    }	
		    neuron.setW(newW);
		    neuronNo++;
		}
	}
	
	public List<Neuron> getNeurons() {
		return neurons;
	}

	public void setNeurons(List<Neuron> neurons) {
		this.neurons = neurons;
	}
	
	
}
