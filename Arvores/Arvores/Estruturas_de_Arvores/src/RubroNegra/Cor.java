package RubroNegra;

public enum Cor {
    RUBRO("Rubro"),
    NEGRO("Negro");

    private String descricao;

    private Cor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
