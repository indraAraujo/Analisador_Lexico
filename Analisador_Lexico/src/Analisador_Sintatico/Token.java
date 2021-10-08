
public class Token{
    private String type; //Atributo para armazenar o tipo do token
    private String info; //Atributo para armazenar o próprio token

    //Construtor da classe
    public Token(String type, String info) {
        this.type = type;
        this.info = info;
    }

    //Método para retornar o tipo do token
    public String getType(){
        return type;
    }

    //Método para retornar o token
    public String getInfo(){
        return info;
    }

    //Método para imprimir o token e seu tipo
    public String toString(){
        return (" " + type + " -> " + info + "\n");
    }

}
