package abd.p1.math;

public class SphericalGeometry {
	
	private static final int R = 6371000;

	private SphericalGeometry() {
	}
	
	public static double haversineFormula(double lat1, double long1, double lat2, double long2) {
		double phiDiff = lat1 - lat2;
		double thetaDiff = long1 - long2;
		double a = Math.sin(phiDiff/2) * Math.sin(phiDiff/2) +
				Math.cos(lat1) * Math.cos(lat2) *
				Math.sin(thetaDiff/2) * Math.sin(thetaDiff/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double res = R * c;
		return res;
	}
	
	public static double haversineFormulaDegrees(double lat1, double long1, double lat2, double long2) {
		return haversineFormula(degToRad(lat1), degToRad(long1), degToRad(lat2), degToRad(long2));
	}
	
	public static double degToRad(double deg) {
		return deg * Math.PI / 180;
	}
	
	public static double radToDeg(double rad) {
		return rad * 180 / Math.PI;
	}

}
