using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class dialog : MonoBehaviour
{
    public TextMeshProUGUI textDisplay;
    public static string[] sentences = ["",""];
    private int index;
    public float typingSpeed;
    public GameObject continueButton;

    void Start()
    {
        StartCoroutine(Type());
    }

    void Update() 
    {
        if(textDisplay.text == sentences[index])
        {
            continueButton.SetActive(true);
        }



        
        if(textDisplay.text == sentences[3]) 
        {
            textDisplay.color = new Color(0.9f, 0.9f, 0.1f);  
        }
        
        if(textDisplay.text == sentences[6]) 
        {
            textDisplay.color = new Color(0.9f, 0.9f, 0.1f);  
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

        if(index < sentences.Length - 1)
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
