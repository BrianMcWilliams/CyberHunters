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
        "This door is locked, there are sockets and it appears that the wires I found on the way here fit perfectly... I'll open my bag.", //3
        "Hi, my name is Spec.t.r.u.m, it stands for Special, Tech, Robot, Universal, Maintenance.", //4
        "Hmm my last update was in 2184 and I’ve been shut downed since then. What year is it?",
        "It is 3084.",
        "I am unable to connect to the current servers, they must be down. Do you know what happened?",
        "No... I don't even know what this place is...",
        "I’ll run a quick analysis…",
        "Based on my information, this was a data center, it stored every data from the Internet, such as numeric pictures or videos",
        "In 2019, data centers emitted as much CO2 as air travel in the United States.",
        "And then in 2100, the Internet alone became the world’s main source of pollution and generated as much greenhouse gas in the atmosphere as fossil-fuel emissions.",
        "In the year 2184, every data center overheated and stopped functioning leading to the fall of humanity.",
        "Here, let me show you around, you’ll understand better.", //14
        "It was crucial for these servers to be in perfect shape, or else everything went down.", //15
        "Like the heat coming from a cell phone as it is being used, data centers, containing the equivalent of thousands of servers...", 
        "Heated up proportionately and required a huge amount of cooling energy to keep them in condition, polluting the air around them.", //17
        "There wasn’t enough awareness about the effect of the Internet and people continued to consume more and more.", //18
        "No one knew that its usage was harmful. People couldn’t realize the implications of their consumption.",// 19
        "I'll show you the after-effect of the Internet, from cryptocurrency, streaming, social media to electronic waste and how it affected these data centers and consequently, the environment.", //20
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
        Character.Robot,                                                                                                                                                                                          
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
        if(textDisplay.text == sentences[index])
        {
            continueButton.SetActive(true);
        }


        // example 
        // get the text: 
        // sentences[index] 

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

        if(index < indexEnd)
        {
            index++;
            textDisplay.text = ""; 
            StartCoroutine(Type());
        } 
        else
        {
            textDisplay.text = "";
            continueButton.SetActive(false);
        }
    }



}
