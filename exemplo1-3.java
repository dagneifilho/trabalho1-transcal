import java.lang.Math;

class exemplo13{
	public static void main(String[] args){
		double T = metodoBissecao();
		double T_celsius = T- 273.15;
		System.out.printf("T_s = %2f K\nT_s = %2fºC\n",T,T_celsius);


	}
	public static double Raiz(double T_s){
		double q = 329.65 * Math.pow(10,3);
		double pi = Math.PI;
		double d = 3.0;
		double l = 6;
		double area = (pi * d * l + (pi * Math.pow(d,2))/4);
		

		double h,T_infinity,sigma,epsilon,T_viz;
		h = 35;
		epsilon = 0.83;
		sigma = 5.67 * Math.pow(10,-8);
		T_infinity = 25+273.15;
		T_viz = T_infinity;
		
		double raiz = area*(h * (T_s - T_infinity) + sigma * epsilon*(Math.pow(T_s,4)-Math.pow(T_viz,4))) - q;

		return raiz;
	}
	public static  double metodoBissecao(){
		double erro = Math.pow(10,-5);
		double n = Math.pow(10,10);
		double a = 273.15;
		double b = 500;																																																															
		double u,v;
		double T = 0;
		u = Raiz(a);
		v = Raiz(b);
		double d = u * v;

		if (d > 0 ){
			System.out.println("Estime novo intervalo.");
		} else {
			for (int k = 1; k < n; k++){
				double c = a + (b-a) / 2;
				double w = Raiz(c);
				if (Math.abs(w)<=erro){
					T = c;
					break;
				} 

				d = w * u;
				if (d < 0){
					b = c;
					v = w;
				} else {
					a = c;
					u = w;
				}
			}
		}
		System.out.println(n);
		return T;
	}

}
