describe('Application Web de Gestion de Voitures', () => {
    beforeEach(() => {
        // recharger la page d'accueil avant chaque test
        cy.visit('http://localhost:8080/esieaFront');
    });

    it('affiche le snackbar en cas d\'erreur', () => {
        // vérifie que le snackbar d'erreur n'est pas affiché initialement
        cy.get('#snackbar_erreur').should('not.have.class', 'show');

        // déclenche l'affichage du snackbar d'erreur
        cy.window().invoke('afficherSnackbar', 'snackbar_erreur');

        // vérifie que le snackbar d'erreur est maintenant affiché
        cy.get('#snackbar_erreur').should('have.class', 'show');
    });

    it('génère la pagination correctement', () => {
        // vérifie qu'il y a deux liens de pagination initialement
        cy.get('div.pagination div#pages a').should('have.length', 2);
    });

    it('sélectionne correctement la page', () => {
        // vérifie que la première page est active initialement
        cy.get('div#pages a.active').should('have.text', '1');

        // sélectionne la deuxième page en invoquant la fonction JavaScript
        cy.window().invoke('selectionnerPage', 2, 20);

        // vérifie que la deuxième page est maintenant active
        cy.get('div#pages a.active').should('have.text', '2');
    });

});