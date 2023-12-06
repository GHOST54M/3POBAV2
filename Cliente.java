import java.util.Date;

public class Cliente {
  private int id;
  private String nome;
  private String endereco;
  private String cep;
  private String pais;
  private String cpf;
  private String passaporte;
  private String email;
  private Date dataNascimento;

  public Cliente(int id, String nome, String endereco, String cep, String pais, String cpf, String passaporte,
      String email, Date dataNascimento) {
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.cep = cep;
    this.pais = pais;
    this.cpf = cpf;
    this.passaporte = passaporte;
    this.email = email;
    this.dataNascimento = dataNascimento;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPassaporte() {
    return passaporte;
  }

  public void setPassaporte(String passaporte) {
    this.passaporte = passaporte;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  @Override
  public String toString() {
    return 
        "\n ID do cliente:" + id +
        "\n Nome do cliente:" + nome +
        "\n Endereço:" + endereco +
        "\n CEP:" + cep +
        "\n País:" + pais +
        "\n CPF:" + cpf +
        "\n Passaporte:" + passaporte +
        "\n E-mail:" + email +
        "\n Data de nascimento:" + dataNascimento + "\n";
  }
}
