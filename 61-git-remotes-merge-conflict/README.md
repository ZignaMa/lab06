# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
2. Ci si assicuri di avere localmente entrambi i branch remoti
<!-- marco@SAMSUNG-PC-MARCO MINGW64 ~/OneDrive/Desktop/OOP/LAB/prova06/lab06/61-git-remotes-merge-conflict/OOP-git-merge-conflict-test (master)
$ git log --oneline --graph --all
* bed943f (origin/feature) Print author information
| * 8e0f29c (HEAD -> master, origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
|/  
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld -->
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
<!-- $ git checkout master 
Already on 'master'
Your branch is up to date with 'origin/master'. -->
   e da qui si esegua il merge di `feature`
   <!-- $ git merge origin/feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result. -->
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
<!-- modificato a mano poi fatto git add della modifica e poi git push sul mio fork -->
6. Si crei un nuovo repository nel proprio github personale
<!-- già fatto -->
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
8. Si faccia push del branch `master` sul proprio repository
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
<!-- $ git branch --set-upstream-to=origin/master
branch 'master' set up to track 'origin/master' -->
