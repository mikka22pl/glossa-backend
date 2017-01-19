package org.ulv.pro.langen.gui.converters;

public interface Convertable<T, U> {

	U fromGui(T guiObj, U obj);
	
	T fromDomain(U obj, T guiObj);
}
