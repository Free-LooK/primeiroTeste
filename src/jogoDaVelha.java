import java.util.Scanner;

public class jogoDaVelha {
    private char[][] tabuleiro; 
    private char marcaAtualDoJogador;

    
             
    private jogoDaVelha() {
        tabuleiro = new char[3][3];
        marcaAtualDoJogador = 'x';
        IniciarJogo();
    }

    
    private void IniciarJogo() {
         
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    
    // Imprime a atual tabela
    public void ImprimeTabuleiro() {
         
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
            
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    
    // Verifica se  o tabuleiro esta cheio e se estiver ele retorna TRUE. Do contrario retorna FALSE
    public boolean isBoardFull() {
    	        boolean isFull = true;
    	         
    	        for (int i = 0; i < 3; i++) {
    	            for (int j = 0; j < 3; j++) {
    	                if (tabuleiro[i][j] == '*') {
    	                    isFull = false;
    	                }
    	            }
    	        }
    	         
    	        return isFull;
    	        
    }
    
    /*
     *	Verifica se os 3 valores são os mesmos (e não vazios) indicando o vencedor.
     *	Esse metodo recebe 3 char sendo eles as jogadas 'x' e 'o'
     *	Caso os 3 elementos sejam iguais ele retorna true.
     */
	private boolean verificarQuemVenceu(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}
    
    
     // Verifica as linhas e ao mesmo tempo usa o metodo "verificarQuemVenceu" para varrer os 3 elementos das linhas e ver se há um vencedor.
    private boolean checarLinhas() {
        for (int i = 0; i < 3; i++) {
            if (verificarQuemVenceu(tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]) == true) {
                return true;
            }
        }
        return false;
    }
     
     
    // Verifica as colunas e ao mesmo tempo usa o metodo "verificarQuemVenceu" para varrer os 3 elementos das colunas e ver se há um vencedor.
    private boolean checarColunas() {
        for (int i = 0; i < 3; i++) {
            if (verificarQuemVenceu(tabuleiro[0][i], tabuleiro[1][i], tabuleiro[2][i]) == true) {
                return true;
            }
        }
        return false;
    }
    
  
         
        // Verifica as duas diagonais para ver se tem um vencedor. Retorna TRUE se tiver algum vencedor.
        private boolean checarDiagonais() {
            return ((verificarQuemVenceu(tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2]) == true) || (verificarQuemVenceu(tabuleiro[0][2], tabuleiro[1][1], tabuleiro[2][0]) == true));
        }
         
         
       // Usa todos os metodos de checagem de vencedor, para saber se alguem venceu de alguma maneira.
        public boolean checaVencedor() {
            return (checarLinhas() || checarColunas() || checarDiagonais());
        }
         
        
        public void exibirVencedor(){
        	System.out.println("O vencedor é o:");
        	
        	
        }
        
         
        // Alterna a atual marca do jogador, ou seja alterna entra a jogada de cada jogador.
        public void trocaDeJogador() {
            if (marcaAtualDoJogador == 'x') {
                marcaAtualDoJogador = 'o';
            }
            else {
                marcaAtualDoJogador = 'x';
            }
        }
         
         
        /*
         Esse metodo pede ao usuário o numero da linha e a coluna para inserir a marca atual do jogador e verifica:
        	1: Se a linha está entre 0 e 2
        	2: Se a coluna está entre 0 e 2
        	3: Se o espaço está vazio
        
        Depois de verificar essa condições ele insere a marca atual do jogador na linha e coluna escrita.
        
        Caso o jogador insera um numero invalido ele vai receber uma mensagem dizendo o erro.
         */

        
        public boolean inserirMarca(int linha, int coluna) {
             
            if ((linha >= 0) && (linha < 3)) {
                if ((coluna >= 0) && (coluna < 3)) {
                    if (tabuleiro[linha][coluna] == '-') {
                        tabuleiro[linha][coluna] = marcaAtualDoJogador;
                        trocaDeJogador();
                        jogadaDoPC();
                        ImprimeTabuleiro();
                        return true;
                        
                    }
                }
            }
            
            
            System.out.println("Numéro inválido.");
            System.out.println("Apenas numeros entre 0 e 2. Também não vale repetir a mesma jogada!");
            
            return false;
            
      }

        
        public void jogadaDoPC(){
        	int x = (int) (Math.random()*3);
        	int y = (int) (Math.random()*3);
        	tabuleiro[x][y] = marcaAtualDoJogador;

        }
        
        public void jogadaDoUsuario(){
        
        	Scanner sc = new Scanner(System.in);
        	
    		int minhaLinha = sc.nextInt();
    		int minhaColuna = sc.nextInt();
    		
            if ((minhaLinha >= 0) && (minhaLinha < 3)) {
                if ((minhaColuna >= 0) && (minhaColuna < 3)) {
                    if (tabuleiro[minhaLinha][minhaColuna] == '-') {
                        tabuleiro[minhaLinha][minhaColuna] = marcaAtualDoJogador;
                        trocaDeJogador();
                        jogadaDoPC();
                        ImprimeTabuleiro();
                        
                    }
                }
            } else {
                
                System.out.println("Numéro inválido.");
                System.out.println("Apenas numeros entre 0 e 2. Também não vale repetir a mesma jogada!");
                
        		
            }
            sc.close();
        
        }
 
    
        
    
    public static void main(String[] args) {
    	jogoDaVelha a = new jogoDaVelha();

		a.inserirMarca(0, 0);
		
		
        
        
        
    }
   
    
}


