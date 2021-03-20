using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public enum Character
{ 
    Player,
    Robot,
}
public class dialog : MonoBehaviour
{
    public TextMeshProUGUI textDisplay;
    public static string[] sentences = { 
        "Hi I am Spec.T.R.U.M", //Index 0
        "I am a robot", //Index 1
        "I am a human", //Index 2
    };
    public static Character[] speaker =
    {
        Character.Robot,
        Character.Robot,
        Character.Player,
    };
    int index;
    public int indexStart;
    public int indexEnd;
    public float typingSpeed;
    public GameObject continueButton;

    void Start()
    {
        index = indexStart;
        StartCoroutine(Type());
    }

    void Update() 
    {
        if(textDisplay.text == sentences[indexStart])
        {
            continueButton.SetActive(true);
        }

        
        if(textDisplay.text == sentences[3]) 
        {
            textDisplay.color = new Color(0.9f, 0.9f, 0.1f);  
        }
        // example 
        // get the text: 
        // sentences[index] 

        // check who's talking
        //if(speaker[index] == Character.Player)
            // change color

        //if(speaker[index] == Character.Robot)
            // default color

        if (textDisplay.text == sentences[6]) 
        {
            textDisplay.color = new Color(0.9f, 0.9f, 0.1f);  
        } 
    }

    IEnumerator Type()
    {
        foreach(char letter in sentences[indexStart].ToCharArray())
        {
            textDisplay.text += letter;
            yield return new WaitForSeconds(typingSpeed);
        }
    }

    public void NextSentence()
    {
        continueButton.SetActive(false);

        if(indexStart < indexEnd)
        {
            index++;
            textDisplay.text = ""; 
            textDisplay.color = new Color(0.4f, 1.0f, 1.0f); 
            StartCoroutine(Type());
        } 
        else
        {
            textDisplay.text = "";
            continueButton.SetActive(false);
        }
    }



}
