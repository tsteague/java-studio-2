import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCounter
{
  private static String MY_FILE = "text.txt";

  public static void main( String[] args )
  {
    System.out.println( "Enter a string or Enter 0 to read from our preset file: " );

    Scanner scanner = null;
    BufferedReader br = null;
    String input = "";
    try
    {
      StringBuilder sbFile = new StringBuilder();

      scanner = new Scanner( System.in );
      if ( scanner.hasNextInt() && scanner.nextInt() == 0 )
      {
        br = new BufferedReader( new FileReader(MY_FILE) );
        String line = null;
        while( (line = br.readLine()) != null )
        {
          sbFile.append( line );
        }
        input = sbFile.toString();
      }    
      else
      {
        input = scanner.nextLine();
      }

      Map<Character,Integer> charMap = new HashMap<Character,Integer>();
      for ( Character letter : input.toCharArray() )
      {
        if ( charMap.containsKey(letter) )
        {
          charMap.put(letter, (charMap.get(letter) + 1) );
        }
        else
        {
          charMap.put( letter, 1 );
        }
      }
      print( charMap );
    }
    catch ( Exception e )
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        br.close();
      } catch( Exception e ) {}
    }
  }

  private static void print( Map<Character,Integer> letters )
  {
    for ( Character letter : letters.keySet() )
    {
      System.out.println( letter + ": " + letters.get(letter) );
    }
  }
}
