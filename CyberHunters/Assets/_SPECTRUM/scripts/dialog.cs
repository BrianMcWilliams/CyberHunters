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
        "I wonder what I’ll find today. Perhaps some batteries or magnets. I know somebody needs some for their lights.", //Index 0
        "What is this? I’ve never seen this type of… rope… I should keep it in case I need it later on.", //Index 1
        "Shiny crystals, they seem to lead somewhere, I should follow them.", //Index 2
        "Oh, that's what the wires were for, I'll open the door to see what's inside.", //3
        "Hi, my name is Spec.t.r.u.m, it stands for Special, Tech, Robot, Universal, Maintenance.", //4
        "Hmm my last update was in 2184 and I’ve been shut down since then. What year is it?",
        "It is 3084.",
        "I am unable to connect to the current servers, they must be down. Do you know what happened?",
        "No... I don't even know what this place is...",
        "I’ll run a quick analysis…",
        "Based on my information, this was a data center, it stored every data from the Internet, such as numeric pictures or videos.",
        "In the year 2184, every data center overheated and stopped functioning, leading to the fall of humanity.",
        "Here, let me show you around, you’ll understand better.", //12
        "In 2019, data centers emitted as much CO2 in the atmosphere as airplanes in the United States.", //13
        "And then in 2100, the Internet alone became the world’s main source of pollution.",
        "Like the heat coming from a cell phone as it is being used, data centers, containing the equivalent of thousands of servers, heated up proportionately.", 
        "They required a huge amount of cooling energy to keep them in condition, polluting the air around them.", //16
        "There wasn’t enough awareness about the effect of the Internet and people continued to consume more and more.", //17
        "No one knew that its usage was harmful. People couldn’t realize the implications of their consumption.",// 18
        "I'll show you the after-effect of the Internet, from cryptocurrency, streaming, social media to electronic waste and how it affected these data centers and consequently, the environment.", //19
    };
    public static Character[] speaker =
    {
        Character.Player,
        Character.Player,
        Character.Player,
        Character.Player,
        Character.Robot,
        Character.Robot,
        Character.Player,
        Character.Robot,
        Character.Player,
        Character.Robot,
        Character.Robot,
        Character.Robot,
        Character.Robot,
        Character.Robot,
        Character.Robot,              
        Character.Robot,
        Character.Robot,
        Character.Robot,
        Character.Robot,   
        Character.Robot,                                                                                                                                                                                          
    };
    int index;
    public int indexStart;
    public int indexEnd;
    public float typingSpeed;
    public GameObject continueButton;

    void Start()
    {
        if(DialogManager.isTalking)
        {
            DialogManager.indexEnd = indexEnd; 
            gameObject.SetActive(false);

        }
        else
        {
            DialogManager.indexEnd = indexEnd; 
            DialogManager.isTalking = true;
            index = indexStart;
            StartCoroutine(Type());
        }
        
    }

    void Update() 
    {
        if(textDisplay.text == sentences[index])
        {
            continueButton.SetActive(true);     
        }


        // check who's talking
        if(speaker[index] == Character.Player)
        {
            textDisplay.color = new Color(0.9f, 0.9f, 0.1f); 
        }

        if(speaker[index] == Character.Robot)
        {
            textDisplay.color = new Color(0.4f, 1.0f, 1.0f); 
        }



    }

    IEnumerator Type()
    {
        foreach(char letter in sentences[index].ToCharArray())
        {
            textDisplay.text += letter;
            yield return new WaitForSeconds(typingSpeed);
        }
    }

    public void NextSentence()
    {

        continueButton.SetActive(false);
        

        if(index < DialogManager.indexEnd)
        {
            index++;
            textDisplay.text = ""; 
            StartCoroutine(Type());
        } 
        else
        {
            DialogManager.isTalking = false;
            textDisplay.text = "";

            continueButton.SetActive(false);
            
        }
    }



}
