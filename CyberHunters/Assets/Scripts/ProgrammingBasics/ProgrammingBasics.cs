using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ProgrammingBasics : MonoBehaviour
{
    public TextMesh textMesh;
    public TextMesh timerTextMesh;
    // Start is called before the first frame update
    void Start()
    {
        string myMessageForTheConsole = "Write something here";
        string myTextForTheScreen = "Text to put on screen";

        Debug.Log("Hello World");

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
