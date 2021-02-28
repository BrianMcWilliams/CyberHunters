using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProgrammingBasics : MonoBehaviour
{
    public TextMesh textMesh;             //These are variables, use them to modify the text you see on screen
    public TextMesh timerTextMesh;
    // Start is called before the first frame update
    void Start()
    {
        //These variables we are going to use for storing our messages, try using these with Debug.Log()
        string myMessageForTheConsole = "Write something here";    
        string myTextForTheScreen = "Text to put on screen";

        Debug.Log("Hello World");

        //You can use textMesh.text and textMesh.color to modify the text and color you see on screen;
        //Keep in mind there are 2 textMesh variables, pay attention to which one you are modifying

        //textMesh.text = "I love bagels";
        //textMesh.color = new Color(1.0f, 0.1f, 0.2f);  //Red,Green,Blue

    }

    float timeToWait = 8.0f;
    // Update is called once per frame
    void Update()
    {

        timeToWait -= Time.deltaTime;
        timerTextMesh.text = timeToWait.ToString();
        
        /* if(timeToWait < 0 )
        {
            textMesh.text = "I love bagels";
            textMesh.color = new Color(1.0f, 0.1f, 0.2f);
        }
        */
    }
}
