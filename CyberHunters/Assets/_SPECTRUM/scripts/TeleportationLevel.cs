using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class TeleportationLevel : MonoBehaviour
{
    public int indexLevel;
    public Animator levelAnim;
    public Animator musicAnim;
    public float WaitTime;
    
    public void Activate()
    {
        StartCoroutine(Wait());
        levelAnim.SetTrigger("FadeOut");
        DialogManager.isTalking = false;
    }

    IEnumerator Wait()
    {
        musicAnim.SetTrigger("fadeOut");
        yield return new WaitForSeconds(WaitTime);
        SceneManager.LoadScene(indexLevel);
    }


}
