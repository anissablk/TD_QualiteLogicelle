// cypress/integration/app_spec.js

describe('Application Web de Gestion de Voitures', () => {
    beforeEach(() => {
        // Visitez la page d'accueil avant chaque test
        cy.visit('http://localhost:8080/esieaFront');
    });

    it('affiche le snackbar en cas d\'erreur', () => {
        // Vérifie que le snackbar d'erreur n'est pas affiché initialement
        cy.get('#snackbar_erreur').should('not.have.class', 'show');

        // Déclenche l'affichage du snackbar d'erreur
        cy.window().invoke('afficherSnackbar', 'snackbar_erreur');

        // Vérifie que le snackbar d'erreur est maintenant affiché
        cy.get('#snackbar_erreur').should('have.class', 'show');
    });

    it('génère la pagination correctement', () => {
        // Vérifie qu'il y a deux liens de pagination initialement
        cy.get('div.pagination div#pages a').should('have.length', 2);
        // Vous devrez peut-être ajuster cette attente en fonction du nombre attendu
    });

    it('sélectionne correctement la page', () => {
        // Vérifie que la première page est active initialement
        cy.get('div#pages a.active').should('have.text', '1');

        // Sélectionne la deuxième page en invoquant la fonction JavaScript
        cy.window().invoke('selectionnerPage', 2, 20);

        // Vérifie que la deuxième page est maintenant active
        cy.get('div#pages a.active').should('have.text', '2');
    });

    // Ajoutez d'autres tests en fonction de vos besoins
});