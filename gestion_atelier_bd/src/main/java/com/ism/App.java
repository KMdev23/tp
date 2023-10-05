package com.ism;

import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.entities.Unite;
import com.ism.repositories.ITables;
import com.ism.repositories.list.TableArticleConfections;
import com.ism.repositories.list.TableCategories;
import com.ism.repositories.list.TableUnites;
import com.ism.services.ArticleConfectionServiceImpl;
import com.ism.services.CategorieServiceImpl;
import com.ism.services.UniteServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ITables<Categorie> repository=new TableCategories();
        CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl(repository);

        //ITables<ArticleConfection> re =new TableArticleConfections();
        //ArticleConfectionService articleConfectionService = new ArticleConfectionService(re);

        ITables<ArticleConfection> re =new TableArticleConfections();
        ArticleConfectionServiceImpl articleConfectionServiceimpl= new ArticleConfectionServiceImpl(re);


        ITables<Unite> reposi = new TableUnites();
        UniteServiceImpl UniteServiceImpl = new UniteServiceImpl(reposi);
       int choix;
       Scanner scanner=new Scanner(System.in);
       do{
           System.out.println("_*!*_*!*__*!*_*!*_*_*!*_\n" +
                   "_*!*_  1-Ajouter   _*!*_\n" +
                   "_*!*_  2-Lister\t   _*!*_\n" +
                   "_*!*_  3-Suprimer  _*!*_\n" +
                   "_*!*_  4-Modifier  _*!*_\n" +
                   "_*!*_  5-Quitter  _*!*_\n" +
                   "_*!*__*!*__*!*__*!*__*!*_");
           choix= scanner.nextInt();
           scanner.nextLine();

           switch (choix){
               case 1:
                        do {
                            System.out.println("1-Ajouter Categorie");
                            System.out.println("2-Ajouter Unite");
                            System.out.println("3-Ajouter Article de confection");
                            System.out.println("4-Quitter");
                            choix = scanner.nextInt();
                            scanner.nextLine();
                            switch (choix){
                                case 1:
                                    System.out.println("Entrez le libelle");
                                    Categorie categorie=new Categorie(scanner.nextLine());
                                    System.out.println(categorie);
                                    categorieServiceImpl.add(categorie);
                                    break;
                                case 2:
                                    System.out.println("enter");
                                    Unite un = new Unite(scanner.nextLine());
                                    UniteServiceImpl.add(un);

                                    break;
                                case 3:
                                    System.out.println("enter l'article de confection");
                                    System.out.println("entrer son id");
                                    int id = scanner.nextInt();
                                    System.out.println("entrer son  libelle");
                                    scanner.nextLine();
                                    String lib = scanner.nextLine();
                                    System.out.println("entrer son prix");
                                    double prix = scanner.nextDouble();
                                    System.out.println("entrer sa quantite");
                                    int qte = scanner.nextInt();
                                    ArticleConfection art = new ArticleConfection(id,lib,prix,qte);
                                    articleConfectionServiceimpl.add(art);
                                    break;
                            }
                        }while (choix!=4);
                   break;
               case 2:
                       do {
                           System.out.println("1-Lister Categorie");
                           System.out.println("2-Lister Unite");
                           System.out.println("3-lister Article de confection");
                           System.out.println("4-Quitter");
                           choix = scanner.nextInt();
                           scanner.nextLine();
                           switch (choix){
                               case 1:
                                   categorieServiceImpl.getAll().forEach(System.out::println);
                                   break;
                               case 2:
                                   UniteServiceImpl.getAll().forEach(System.out::println);
                                   break;
                               case 3:
                                   articleConfectionServiceimpl.getAll().forEach(System.out::println);
                                   break;
                           }
                       }while (choix!=4);
                       break;
                    default:
                    break;

               case 3:
                   do {
                       System.out.println("1-Suprimmer Categorie");
                       System.out.println("2-Suprimmer Unite");
                       System.out.println("3-Quitter");
                       choix = scanner.nextInt();
                       scanner.nextLine();
                       switch (choix){
                           case 1:
                               int n;
                               do {
                                   System.out.println("Entrez id ");
                                   n= scanner.nextInt();
                                   if (categorieServiceImpl.show(n)!=null){
                                       categorieServiceImpl.remove(n);
                                       break;
                                   }else System.out.println("libelle introuvable");
                                }while (n!=repository.indexOf(n));

                               break;
                           case 2:
                               do {
                                   System.out.println("Entrez id ");
                                   n= scanner.nextInt();
                                   if (UniteServiceImpl.show(n)!=null){
                                       UniteServiceImpl.remove(n);
                                       break;
                                   }else System.out.println("libelle introuvable");
                               }while (n!=repository.indexOf(n));

                               break;
                       }
                   }while (choix!=3);
                   break;
               case 4:
                   do {
                       System.out.println("1-Modifier Categorie");
                       System.out.println("2-Modifier Unite");
                       System.out.println("3-Quitter");
                       choix = scanner.nextInt();
                       scanner.nextLine();
                       switch (choix){
                           case 1:
                               int id;
                               do {
                                   System.out.println("Entrez id ");
                                   id= scanner.nextInt();
                                   if (categorieServiceImpl.show(id)!=null){
                                       System.out.println("entrez le libelle a modifier :");
                                       scanner.nextLine();
                                       Categorie cate=new Categorie(id, scanner.nextLine());
                                       categorieServiceImpl.update(cate);
                                       break;
                                   }else System.out.println("libelle introuvable");
                               }while (id!=repository.indexOf(id));
                               break;
                           case 2:
                               do {
                                   System.out.println("Entrez id ");
                                   id= scanner.nextInt();
                                   if (UniteServiceImpl.show(id)!=null){
                                       System.out.println("entrez nouveau id:");
                                       int it =scanner.nextInt();
                                       System.out.println("entrez nouveau id:");
                                       String lib =scanner.nextLine();
                                       Unite unite=new Unite(id,lib);
                                       UniteServiceImpl.update(unite);
                                       break;
                                   }else System.out.println("libelle introuvable");
                               }while (id!=repository.indexOf(id));
                               break;
                       }
                   }while (choix!=3);


                   break;
           }

           
           
       }while(choix!=5);
    }
}
