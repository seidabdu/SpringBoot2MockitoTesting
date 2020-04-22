package com.example.seid.springtest.util;

import com.example.seid.springtest.model.ToDo;

public class PayloadValidator {

	public static boolean validateCreatePayload(ToDo toDo) {
		if (toDo.getId() > 0) {
			return false;
		}
		return true;
	}

}
