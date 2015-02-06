package fantastic;

public class FantasticDebug 
{
	public static boolean DebugMode = false;
	
	public static void Output(String aDebugString)
	{
		if (DebugMode)
		{
			System.out.println(Long.toString(System.currentTimeMillis())+": "+ aDebugString);
		}
	}
	
	//Usefull for debugging. You can turn off the debugger, but you can force the output for specifc lines.
	public static void Output(String aDebugString, boolean forceOutput)
	{
		if (forceOutput)
		{
			System.out.println(Long.toString(System.currentTimeMillis())+": "+ aDebugString);
		}
	}
}
