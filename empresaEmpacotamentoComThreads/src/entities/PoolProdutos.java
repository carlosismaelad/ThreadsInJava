package entities;

public final class PoolProdutos extends ContadorSinc {
    //Métodos
    public PoolProdutos ( int qtdade_produtos ) {
        super ( qtdade_produtos );
        if ( qtdade_produtos < 1 )
            throw new IllegalArgumentException ( "Argumentos ilegais utilizados no construtor de PoolProdutos." );
    }
    public synchronized int retirarProdutos ( int nr_produtos ) {
        int aux = getContador ();
        if ( ( aux - nr_produtos ) >= 0 ) { //Há produtos disponíveis suficientes para atender à retirada.
            decrementar ( nr_produtos );
            return nr_produtos;
        } else { //Os produtos são insuficientes ou inexistentes.
            zerarContador ();
            return aux;
        }
    }
}
