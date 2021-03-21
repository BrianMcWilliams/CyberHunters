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
        "Hi, my name is Spec.t.r.u.m, it stands for Special, Technological, Robot, Upkeep, Maintenance.",
        "Abnormal, this room is at 40°C, it is supposed to be at 20°C.",
        "What year is it?",
        "It is 3084.",
        "Hmm my last update was in 2084 and I’ve been shut downed since then.",
        "Plus, I am unable to connect to the current servers, they must be down. Do you know what happened?",
        "No...",
        "I’ll run a quick analysis…",
        "Based on my information, these machines needed to be constantly cooled off since they stored every data, such as numeric pictures or watching movies.",
        "In 2020, if The Internet was a country, it would’ve been the 5th largest consumer of electricity.",
        "And then in 2050, The Internet alone became the world’s main source of pollution and generated as much greenhouse gas in the atmosphere as fossil-fuels emissions.",
        "In the year 2084, every data center overheated and stopped functioning leading to the fall of humanity and leaving billions of homes without technology.",
        "Here,  let me show you around, you’ll understand better.",
        "It was crucial for these servers to be in perfect shape, or else, everything went down.",
        "Like the heat coming from a cell phone as it is being used, data centers, containing the equivalent of thousands of servers, heated up proportionately and required a huge amount of cooling energy to keep them in condition, polluting the air around them.",
        "There wasn’t enough awareness about its effect and people continued to consume more and more.",
        "No one knew that the usage of the internet was harmful. People couldn’t realize the implications of their consumption.",
        "I'll show you the after effect of The Internet, from crypto money, streaming, social media to electronic waste and how it affected these data centers and consequently, the environment.",
    };
    public static Character[] speaker =
    {
        Character.Player,
        Character.Player,
        Character.Player,
        Character.Robot,
        Character.Robot,
        Character.Robot,
        Character.Player,
        Character.Robot,
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
