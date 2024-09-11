package cmu.detector.console.output;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.util.Observable;

public class ObservableExclusionStrategy implements ExclusionStrategy {

	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
	
	public boolean shouldSkipField(FieldAttributes field) {
		return field.getDeclaringClass().equals(Observable.class) && ( field.getName().equals("obs") || field.getName().equals("changed"));
	}
}