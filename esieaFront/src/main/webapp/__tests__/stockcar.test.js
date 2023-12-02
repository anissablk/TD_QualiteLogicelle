const fs = require('fs');
const html = fs.readFileSync('src/main/webapp/index.html', 'utf-8');

// module JSDOM pour simuler un environnement de navigateur
const { JSDOM } = require('jsdom');
const dom = new JSDOM(html);

global.document = dom.window.document;

// les 3 fonctions qu'on veut tester
const {
    afficherSnackbar,
    genererPagination,
    selectionnerPage,
} = require('./stockcar');

describe('afficherSnackbar', () => {
    test('affiche le snackbar', () => {
        afficherSnackbar('snackbar_erreur');
        // recupère  l'élément du DOM avec l'id 'snackbar_erreur'
        const snackbar = document.getElementById('snackbar_erreur');
        // verifie que la classe 'show' a été ajoutée à l'élément
        expect(snackbar.classList.contains('show')).toBe(true);
    });
});

describe('genererPagination', () => {
    test('génère la pagination correctement', () => {
        document.body.innerHTML = '<div class="pagination"></div>';
        genererPagination(20, 1);
        // récupere  tous les liens de pagination générées
        const pages = document.querySelectorAll('div.pagination div#pages a');
        // vérifie le nombre de pages générées
        expect(pages.length).toBe(2); // 2 pages car 20 lignes et ligneParPage par défaut = 10
    });
});

describe('selectionnerPage', () => {
    test('sélectionne correctement la page', () => {
        document.body.innerHTML = '<div class="pagination"></div>';
        selectionnerPage(2, 20);

        const activePage = document.querySelector('div#pages a.active');
        expect(activePage.innerHTML).toBe('2');
    });
});