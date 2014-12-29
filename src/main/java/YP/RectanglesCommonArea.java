package YP;

public class RectanglesCommonArea {
//rect_1_upper_left_x
//rect_2_upper_left_x	
//intersect_upper_left_x = max( rect_1_upper_left_x , rect_2_upper_left_x ) 
//intersect_upper_left_y = min( rect_1_upper_left_y , rect_2_upper_left_y )
	public static void main(String[] args) throws Exception{
		
		Rectangle R0 = new Rectangle(new Point(2.0, 3.0), new Point(5.0, 7.0));
		Rectangle Q0 = new Rectangle(new Point(1.0, 2.0), new Point(4.0, 8.0));
		//System.out.println(commonArea(R0, Q0));
		System.out.println(overlappingArea(R0, Q0));

		Rectangle R1 = new Rectangle(new Point(12.0, 3.0), new Point(15.0, 7.0));
		Rectangle Q1 = new Rectangle(new Point(1.0, 2.0), new Point(4.0, 8.0));
		//System.out.println(commonArea(R1, Q1));
		System.out.println(overlappingArea(R1, Q1));

		Rectangle R2 = new Rectangle(new Point(1.0, 2.0), new Point(5.0, 7.0));
		Rectangle Q2 = new Rectangle(new Point(2.0, 3.0), new Point(4.0, 8.0));
		//System.out.println(commonArea(R2, Q2));
		System.out.println(overlappingArea(R2, Q2));
		Rectangle R4 = new Rectangle(new Point(2.0, 3.0), new Point(4.0, 8.0));
		Rectangle Q4 = new Rectangle(new Point(1.0, 2.0), new Point(5.0, 7.0));
		//System.out.println(commonArea(R4, Q4));
		System.out.println(overlappingArea(R4, Q4));
		Rectangle R5 = new Rectangle(new Point(5.0, 7.0), new Point(1.0, 2.0));
		Rectangle Q5 = new Rectangle(new Point(4.0, 8.0), new Point(2.0, 3.0));
		//System.out.println(commonArea(R5, Q5));
		System.out.println(overlappingArea(R5, Q5));
	}
	static double overlappingArea(Rectangle R, Rectangle Q) throws Exception {
		double length = intersectWidth(new Interval(R.A.x, R.C.x), new Interval(Q.A.x, Q.C.x));
		double width = intersectWidth(new Interval(R.A.y, R.C.y), new Interval(Q.A.y, Q.C.y));
		return length * width;
	}
	static class Rectangle {
		Point A;
		Point C;
		Rectangle(Point A, Point C){
			this.A=A;
			this.C=C;
		}
	}	
	static class Interval {//always a<=b so if it is not it will be swapped so an interval of [a, b] is a closed interval starting from a ending to b
		double a; 
		double b;
		Interval(double a, double b) {
			if (a>b) {
				this.a=b;
				this.b=a;
			} else {
				this.a=a;
				this.b=b;
			}
		}
	}
	static class Point {
		double x;
		double y;
		Point(double x, double y){
			this.x=x;
			this.y=y;
		}
	}
	static double intersectWidth(Interval interval1, Interval interval2) {
		return Math.max(0, Math.min(interval1.b, interval2.b) - Math.max(interval1.a, interval2.a));
	}
//	static double commonArea(Rectangle R, Rectangle Q) throws Exception {
//		double length = intersectLength(new Interval(R.A.x, R.C.x), new Interval(Q.A.x, Q.C.x));
//		double width = intersectLength(new Interval(R.A.y, R.C.y), new Interval(Q.A.y, Q.C.y));
//		return length * width;
//	}
//	static double intersect(Interval interval1, Interval interval2) {
//		double width = Math.min(interval1.b, interval2.b) - Math.max(interval1.a, interval2.a);
//		return width < 0 ? 0 : width;
//	}
//	static class Interval1 {
//		double a;
//		double b;
//		Interval1(double a, double b) throws Exception{
//			if (a>b) {
//				throw new Exception("a should not be greater than b.");
//			}
//			this.a=a;
//			this.b=b;
//		}
//	}
//	static double intersectLength1(Interval i, Interval j) {
//		if (i.b<j.a || j.b<i.a) {
//			//intervals has no overlap
//			return 0.0;
//		}
//		
//		if (j.a<=i.a) { //interval i is not before j
//			if (i.b<=j.b){
//				//interval i is inside interval j
//				return i.b-i.a;
//			} else {
//				//i.b>j.b
//				return j.b-i.a;
//			}
//		} else {//i.a<j.a
//			if (j.b<=i.b){
//				//interval j is inside interval i
//				return j.b-j.a;
//			} else {
//				//j.b>i.b
//				return i.b-j.a;
//			}
//		}
//	}
//	static double intersectLength(Interval i, Interval j) {
//		double x1,x2;
//		if (i.b<j.a || j.b<i.a) {
//			//intervals has no overlap
//			return 0.0;
//		}
//		x1 = Math.max(i.a, j.a);
//		x2 = Math.min(i.b, j.b);
//		return x2 - x1;
//	}
}
