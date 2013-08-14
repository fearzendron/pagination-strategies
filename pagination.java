    /**
    * Doing!!! Não esta acabado
    *
     * @param totalPages Numero total de páginas de um dado registro, por exemplo, se num select * em uma base vierem
     *                   100 registros e o padrão diz que devemos mostrar sempre 10 itens por pagina então teremos um total de 10 páginas.
     * @param actualPage A página atual em que o usuário esta navegando
     * @param maxRange      o total de itens que uma paginação deve mostrar entre as opções de próximo e anterior
     * @return Retorna o hashmap com os itens de uma paginação e qual deve ficar ativado.
     * @author: Chucky
     * <p/>
     * Mètodo responsável por retornar um array com as páginas a serem mostradas na páginação na interface.
     * Exemplo:
     * << 2 3 "4" 5 6 >>
     * | |  |  | |
     * <p/>
     * A quantidade de páginas mostradas segue a váriavel passada "maxRange", o exemplo acima interpretou que
     * a variavel "maxRange" é igual a 5.
     */
    private SortedMap<Integer, String> getPaginationPages(int totalPages, int actualPage, int maxRange) {
        int preciseMaxRange = (totalPages < maxRange) ? totalPages : maxRange;

        SortedMap<Integer, String> pagesList = new TreeMap<>();

        if (preciseMaxRange == 1) {
            pagesList.put(actualPage, "true");
            return pagesList;
        }

        int pagePosition = Math.round((float) preciseMaxRange / 2);

        int countLess = (preciseMaxRange);
        int countMore;

        pagesList.put(actualPage, "true");

        for (int i = (pagePosition - 1); i > 0; i--) {
            int x = 1;
            pagesList.put(actualPage - x, "false");
            x++;
        }

        for (int i = (pagePosition + 1); i < (preciseMaxRange); i++) {
            int x = 1;
            pagesList.put(actualPage + x, "false");
            x++;
        }

        return pagesList;
    }