package com.irvin.pos.exceptions;

/**
 * EntityNotFoundException
 */
public class EntityNotFoundException extends Exception {
	private final String entity;

	public EntityNotFoundException(String entity) {
		super(entity + " was not found or does not exist.");
		this.entity = entity;
	}

	public String getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		return "EntityNotFoundException{" +
				"entity='" + entity + '\'' +
				'}';
	}
}
