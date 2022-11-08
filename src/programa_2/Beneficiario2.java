package programa_2;

public class Beneficiario2 {

		String nomeBnc;
		int idadeBnc,quantDp;
		double valorPlan;
		
		String[] nomeDp = new String[10] ;
		int[] idadeDp = new int[10];
		
		public Beneficiario2( String nomeBnc, int idadeBnc, int quantDp, double valorPlan,String[] nomeDp,int[] idadeDp) {
			
			this.nomeBnc = nomeBnc;
			this.idadeBnc = idadeBnc;
			this.quantDp = quantDp;
			this.valorPlan = valorPlan;
			this.nomeDp = nomeDp;
			this.idadeDp = idadeDp;
		}
		
		
		public int getQuantDp() {
			return quantDp;
		}

		public void setQuantDp(int quantDp) {
			this.quantDp = quantDp;
		}

		public String[] getNomeDp() {
			return nomeDp;
		}

		public void setNomeDp(String[] nomeDp) {
			this.nomeDp = nomeDp;
		}

		public int[] getIdadeDp() {
			return idadeDp;
		}

		public void setIdadeDp(int[] idadeDp) {
			this.idadeDp = idadeDp;
		}

		public String getNomeBnc() {
			return nomeBnc;
		}

		public void setNomeBnc(String nomeBnc) {
			this.nomeBnc = nomeBnc;
		}

		public int getIdadeBnc() {
			return idadeBnc;
		}

		public void setIdadeBnc(int idadeBnc) {
			this.idadeBnc = idadeBnc;
		}

		public double getValorPlan() {
			return valorPlan;
		}

		public void setValorPlan(double valorPlan) {
			this.valorPlan = valorPlan;
		}
		
}
