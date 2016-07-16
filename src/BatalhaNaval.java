public class BatalhaNaval {
	private char tabuleiro[][];
	private char marcaDoBarco;

	public BatalhaNaval() {
		tabuleiro = new char [11][11];
		marcaDoBarco = 'x'; 
		criandoTabuleiro();
	}

	public void criandoTabuleiro(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tabuleiro[i][j] = '-';
			}
		}	
	}

	public void imprimeTabuleiro(){
		System.out.println("     A   B   C   D   E   F   G   H   I   J");
		for (int i = 0; i < 10; i++) {
			if(i!=9){				
			System.out.print((i+1) + "  | ");
			} else System.out.print((i+1) + " | ");			// Qual método mais limpo pra fazer isso? Quero limitar o número de letras.
			for (int j = 0; j < 10; j++) {
				System.out.print(tabuleiro[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void limpaTela(){ // Preciso aprender a deletar tudo e depois colocar um tabuleiro novo.. Como um refresh!
			System.out.print("\033[H\033[2J");
	}
	
	public void trocaDeJogador(){
		if(marcaDoBarco == 'x'){
			marcaDoBarco = 'o';
			} else { marcaDoBarco = 'x';
		}
	}
	
	public boolean inserirMarca(int numero, int letra){
			if((numero>=1) && numero<=11) {
				if ((letra >= 1) && (letra <=11)) {
						if(tabuleiro[numero][letra] == '-'){
								tabuleiro[numero-1][letra-1] = marcaDoBarco;
								imprimeTabuleiro();
								return true;
						}
					}
				}
            System.out.println("Input inválido.");
            System.out.println("Apenas numeros de 1 à 10 e caractéres de (A à J). Também não vale repetir a mesma jogada!");
			return false;
	}

	
	
	public static void main(String[] args) {
		BatalhaNaval jogo = new BatalhaNaval();
		jogo.imprimeTabuleiro();
		jogo.inserirMarca(2, 3);
		jogo.inserirMarca(10, 3);
	}
}
