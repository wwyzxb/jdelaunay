package org.jhydrocell.hydronetwork;

/**
 * Hydronetwork Package.
 *
 * @author Jean-Yves MARTIN, Erwan BOCHER
 * @date 2009-01-12
 * @version 1.1
 */

public class HydroProperties {
	// Constraints types
	static final public int WALL = 1;
	static final public int SEWER = 1 << 1;
	static final public int ROAD = 1 << 2;
	static final public int DITCH = 1 << 3;
	static final public int RIVER = 1 << 4;
	static final public int PARCEL = 1 << 5;

	// Topographic types
	public static final int RIDGE = 1 << 10;
	public static final int TALWEG = 1 << 11;
	public static final int RIGHTSLOPE = 1 << 12;
	public static final int LEFTTSLOPE = 1 << 13;
	public static final int RIGHTSIDE = 1 << 14;
	public static final int LEFTSIDE = 1 << 15;
	public static final int RIGHTWELL = 1 << 16;
	public static final int LEFTWELL = 1 << 17;
	public static final int LEFTCOLINEAR = 1 << 18;
	public static final int RIGHTCOLINEAR = 1 << 19;
	public static final int DOUBLECOLINEAR = 1 << 20;
	public static final int FLAT = 1 << 21;
	public static final int BORDER = 1 << 22;

	// Generalities
	static final public int ANY = -1;
	static final public int NONE = 0;

	/**
	 * return string from int definition
	 * 
	 * @param aType
	 * @return
	 */
	public static String toString(int aType) {
		String returned = "";
		for (int i=0; i<64; i++) {
			int property = 1 << i;
			
			if ((aType & property) != 0) {
				// Property is valid
				if (! returned.equals(""))
					returned += ",";
				returned += propertyToString(property);
			}
		}
		return returned;
	}

	/**
	 * Generate String value for a property
	 * 
	 * @param aProperty
	 * @return aString
	 */
	private static String propertyToString(int aProperty) {
		switch (aProperty) {
		case WALL:
			return "wall";
		case SEWER:
			return "sewer";
		case ROAD:
			return "road";
		case DITCH:
			return "ditch";
		case RIVER:
			return "river";
		case PARCEL:
			return "parcel";
			
		case RIDGE:
			return "ridge";
		case TALWEG:
			return "talweg";
		case RIGHTSLOPE:
			return "right slope";
		case LEFTTSLOPE:
			return "left slope";
		case RIGHTSIDE:
			return "right side";
		case LEFTSIDE:
			return "left side";
		case RIGHTWELL:
			return "right well";
		case LEFTWELL:
			return "left well";
		case RIGHTCOLINEAR:
			return "right colinear";
		case LEFTCOLINEAR:
			return "left colinear";
		case DOUBLECOLINEAR:
			return "double colinear";
		case FLAT:
			return "flat";
		case BORDER:
			return "border";
		default:
			return "";
		}
	}
	
	/**
	 * return int from string definition
	 * 
	 * @param aType
	 * @return
	 */
	public static int fromString(String aType) {
		int i = 0;
		int res = 0;
		boolean found = false;
		while ((i < 64) && (!found)) {
			res = 1 << i;
			if (propertyToString(res).equals(aType))
				found = true;
			else
				i ++;
		}
		if (!found)
			res = 0;
		return res;
	}

	/**
	 * Check if type matches aType
	 * 
	 * @param type
	 * @param aType
	 */
	public static boolean check(int type, String aType) {
		return ((type & fromString(aType)) != 0);
	}

	/**
	 * Check if type matches aType
	 * 
	 * @param type
	 * @param aType
	 */
	public static boolean check(int type, int aType) {
		return ((type & aType) != 0);
	}

}