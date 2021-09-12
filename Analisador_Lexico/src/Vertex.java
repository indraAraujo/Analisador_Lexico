
import java.util.ArrayList;

/* 
 * Essa classe representa um único vértice, o qual é constituído, na representação por
 * listas encadeadas, por um indentificador e uma lista de adjâcencias. Há também
 * uma lista auxiliar "weights" que conterá o peso para cada aresta.
 * */

public class Vertex
{
	public int id;
	public ArrayList<Integer> adjacencies;
	public ArrayList<Character> weights;

	public Vertex ()
	{
		this.id = 0;
		adjacencies = new ArrayList<Integer>();
		weights = new ArrayList<Character>();
	}

	public int id ()
	{
		return this.id;
	}

	public ArrayList<Integer> adjacencies ()
	{
		return adjacencies;
	}

	public ArrayList<Character> weights ()
	{
		return weights;
	}
}

