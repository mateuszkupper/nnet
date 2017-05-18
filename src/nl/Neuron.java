package nl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Neuron {
	private double v;
	private Map<Neuron, Double> w;
	
	public void activate(Layer belowLayer) {
		w = new HashMap<Neuron, Double>();
		int sum=0;
		for(Neuron neuron : belowLayer.getNeurons()) {
			double x = neuron.getV();
			Random r = new Random();					
			Double weight = 1 * r.nextDouble();
			w.put(neuron, weight);
			v+=w.get(neuron)*x;
		}
	}
	
	public void activateTest(Layer belowLayer) {
		v=0;
		for(Neuron neuron : belowLayer.getNeurons()) {
			double x = neuron.getV();
			v+=w.get(neuron)*x;
		}
	}
	
	public double getV() {
		return v;
	}
	
	public void setV(double v) {
		this.v = v;
	}
	
	public Map<Neuron, Double> getW() {
		return w;
	}
	
	public void setW(Map<Neuron, Double> w) {
		this.w = w;
	}
	
	
	
	
}
