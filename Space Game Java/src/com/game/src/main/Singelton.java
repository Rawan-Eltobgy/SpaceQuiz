package com.game.src.main;

public class Singelton {

		  // Private constructor prevents instantiation from other classes
		  private Singelton() {}
		 
		  /**
		   * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
		   * or the first access to SingletonHolder.INSTANCE, not before.
		   */
		  private static class SingletonHolder { 
			
		    private static final Singelton INSTANCE = new Singelton();
		  }

public static Singelton getInstance() {
	  System.out.println("I created a single object of the Quiz ");
    return SingletonHolder.INSTANCE;
  }
}