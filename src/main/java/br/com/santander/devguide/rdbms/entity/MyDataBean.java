package br.com.santander.devguide.rdbms.entity;

import java.util.Date;

public class MyDataBean {

	private long matricula;
	private String descricao;
	private Date dataHora;
	private double valorTotal;

	public MyDataBean() {
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("{matricula=%d, descricao=%s, dataHora=%s, valorTotal=%f}", matricula,
				descricao, dataHora, valorTotal);
	}

}
