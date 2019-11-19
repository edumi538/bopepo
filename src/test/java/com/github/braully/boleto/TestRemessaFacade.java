/*
 * Copyright 2019 Projeto JRimum.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.braully.boleto;

import static com.github.braully.boleto.TagLayout.TagCreator.*;
import java.util.Date;
import org.jrimum.bopepo.BancosSuportados;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author braully
 */
public class TestRemessaFacade {

    @Test
    public void testRemessaCobancaGenericaFebraban240V5SegmentoPQ() {
        RemessaFacade remessa = new RemessaFacade(LayoutsSuportados.LAYOUT_FEBRABAN_CNAB240_COBRANCA_REMESSA);
        remessa.addNovoCabecalho()
                .sequencialArquivo(1)
                .dataGeracao(new Date()).setVal("horaGeracao", new Date())
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoCabecalhoLote()
                .operacao("R")//Operação de remessa
                .servico(1)//Cobrança
                .forma(1)//Crédito em Conta Corrente
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1")
                .convenio("1", "1", "1", "1");

        remessa.addNovoDetalheSegmentoP()
                .valor(1)
                .valorDesconto(0).valorAcrescimo(0)//opcionais
                .dataGeracao(new Date())
                .dataVencimento(new Date())
                .numeroDocumento(1)
                .nossoNumero(1)
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1")
                .convenio("1", "1", "1", "1")
                .sequencialRegistro(1);

        remessa.addNovoDetalheSegmentoQ()
                .sacado("Fulano de Tal", "0")
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1")
                .convenio("1", "1", "1", "1")
                .sequencialRegistro(2);

        remessa.addNovoRodapeLote()
                .quantidadeRegistros(2)
                .valorTotalRegistros(1)
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoRodape()
                .quantidadeRegistros(1)
                .valorTotalRegistros(1)
                .setVal("codigoRetorno", "1")
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        String remessaStr = remessa.render();
        System.err.println(remessaStr);
    }

    @Test
    public void testRemessaCobancaGenericaFebraban240V5() {
        RemessaFacade remessa = new RemessaFacade(LayoutsSuportados.LAYOUT_FEBRABAN_CNAB240_COBRANCA_REMESSA);
        remessa.addNovoCabecalho()
                .sequencialArquivo(1)
                .dataGeracao(new Date()).setVal("horaGeracao", new Date())
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoCabecalhoLote()
                .operacao("R")//Operação de remessa
                .servico(1)//Cobrança
                .forma(1)//Crédito em Conta Corrente
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1")
                .convenio("1", "1", "1", "1");

        remessa.addNovoDetalheSegmentoJ()
                .sacado("Fulano de Tal", "0")
                .codigoBarras("0")
                .valor(1)
                .valorDesconto(0).valorAcrescimo(0)//opcionais
                .dataVencimento(new Date())
                .numeroDocumento(1)
                .nossoNumero(1)
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1")
                .sequencialRegistro(1);

        remessa.addNovoDetalheSegmentoJ52()
                .sacado("Fulano de Tal", "0")
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1")
                .sequencialRegistro(2);

        remessa.addNovoRodapeLote()
                .quantidadeRegistros(2)
                .valorTotalRegistros(1)
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoRodape()
                .quantidadeRegistros(1)
                .valorTotalRegistros(1)
                .setVal("codigoRetorno", "1")
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        String remessaStr = remessa.render();
        System.err.println(remessaStr);
//        assertEquals(remessaStr, "");
    }

    @Test
    public void testRemessaCobancaGenericaSicredi240V5() {
        RemessaFacade remessa = new RemessaFacade(LayoutsSuportados.LAYOUT_SICREDI_CNAB240);
        remessa.addNovoCabecalho()
                .sequencialArquivo(1)
                .dataGeracao(new Date()).setVal("horaGeracao", new Date())
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoCabecalhoLote()
                .operacao("R")//Operação de remessa
                .servico(1)//Cobrança
                .forma(1)//Crédito em Conta Corrente
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1")
                .convenio("1", "1", "1", "1");

        remessa.addNovoDetalheSegmentoJ()
                .sacado("Fulano de Tal", "0")
                .codigoBarras("0")
                .valor(1)
                .valorDesconto(0).valorAcrescimo(0)//opcionais
                .dataVencimento(new Date())
                .numeroDocumento(1)
                .nossoNumero(1)
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1")
                .sequencialRegistro(1);

        remessa.addNovoDetalheSegmentoJ52()
                .sacado("Fulano de Tal", "0")
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1")
                .sequencialRegistro(2);

        remessa.addNovoRodapeLote()
                .quantidadeRegistros(2)
                .valorTotalRegistros(1)
                .banco("0", "Banco")
                .cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        remessa.addNovoRodape()
                .quantidadeRegistros(1)
                .valorTotalRegistros(1)
                .setVal("codigoRetorno", "1")
                .banco("0", "Banco").cedente("ACME S.A LTDA.", "1").convenio("1", "1", "1", "1");

        String remessaStr = remessa.render();
        System.err.println(remessaStr);
//        assertEquals(remessaStr, "");
    }

    @Ignore
    @Test
    public void testRemessaVazia() {
        RemessaFacade remessa = new RemessaFacade(layoutGenericoTest());
        remessa.addNovoCabecalho().agencia("1")
                .conta("1").numeroConvenio("1")
                .cedente("ACME S.A LTDA.").cedenteCnpj("1")
                .dataGeracao(new Date()).setValue("codigoRetorno", "1");

        remessa.addNovoDetalhe().valor("1").vencimento("1")
                .numeroDocumento("1").nossoNumero("1")
                .dataEmissao("1").carteira("1")
                .sacado("Fulano de Tal").sacadoCpf("1")
                .sacadoEndereco("Rua 1, Numero 1, Cidade Z")
                .instrucao("Senhor caixa não receber nunca");

        remessa.addNovoRodape()
                .quantidadeRegistros(1)
                .valorTotalRegistros(1)
                .setValue("codigoRetorno", "1");

        String remessaStr = remessa.render();
        System.err.println(remessaStr);
//        assertEquals(remessaStr, "");
    }

    public TagLayout layoutGenericoTest() {
        TagLayout flatfileLayout = flatfile(
                /*
                <layout>
                <name>Arquivo-Febraban_CNAB400</name>
                <version>Version 00</version>
                <description>
                Layout padrão do Febraban
                </description>
                </layout>
                 */
                layout(
                        nome("Arquivo-Febraban_CNAB400"),
                        descricao("Layout padrão do Febraban"),
                        versao("01"),
                        banco(BancosSuportados.BANCO_DO_BRASIL.create()),
                        cnab(CNAB.CNAB_400),
                        servico(CNABServico.COBRANCA_REMESSA)
                ),
                /*
                        <GroupOfRecords>
                        <Record name="cabecalho" description="Protocolo de comunicação">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1" value="0" />
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="AGENCIA" length="4" type="INTEGER" padding="ZERO_LEFT" />
                        <Field name="DATA_ARQUIVO" length="6" type="DATE" format="DATE_DDMMYY" />
                 */
                cabecalho(
                        fcodigoRegistro().value(0),
                        fcodigoRetorno(),
                        fagencia().length(4),
                        fconta().length(7),
                        fdataGeracao()
                ),
                titulo(
                        fcodigoRegistro().value(7)
                ),
                /*
                        <Record name="TRAILLER">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1"  value="9"/>
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="Filler" length="2" />
                        <Field name="CODIGO_BANCO" length="3" />
                        <Field name="Filler" length="10" />
                        <Field name="QUANTIDADE_TITULOS" length="8" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="VALOR_TOTAL_TITULOS" length="15" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="Filler" length="8" />
                        </GroupOfFields>
                        </Record>
                 */
                rodape(
                        fcodigoRegistro().value(9),
                        fcodigoRetorno(),
                        fzero().length(2),
                        fbranco().length(3),
                        fzero().length(10),
                        fquantidadeRegistros().length(8),
                        fvalorTotalRegistros().length(8),
                        fzero().length(8)
                )
        );
        return flatfileLayout;
    }

    public TagLayout layoutBancoBradescoTest() {
        TagLayout flatfileLayout = flatfile(
                /*
                <layout>
                <name>Arquivo-Febraban_CNAB400</name>
                <version>Version 00</version>
                <description>
                Layout padrão do Febraban
                </description>
                </layout>
                 */
                layout(
                        nome("Arquivo-Febraban_CNAB400"),
                        descricao("Layout padrão do Febraban"),
                        versao("01"),
                        banco(BancosSuportados.BANCO_BRADESCO.create()),
                        cnab(CNAB.CNAB_400),
                        servico(CNABServico.COBRANCA_REMESSA)
                ),
                /*
                        <GroupOfRecords>
                        <Record name="cabecalho" description="Protocolo de comunicação">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1" value="0" />
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="AGENCIA" length="4" type="INTEGER" padding="ZERO_LEFT" />
                        <Field name="DATA_ARQUIVO" length="6" type="DATE" format="DATE_DDMMYY" />
                 */
                cabecalho(
                        fcodigoRegistro().value(0),
                        fcodigoRetorno(),
                        fagencia().length(4),
                        fconta().length(7),
                        fdataGeracao()
                ),
                titulo(
                        fcodigoRegistro().value(7)
                ),
                /*
                        <Record name="TRAILLER">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1"  value="9"/>
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="Filler" length="2" />
                        <Field name="CODIGO_BANCO" length="3" />
                        <Field name="Filler" length="10" />
                        <Field name="QUANTIDADE_TITULOS" length="8" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="VALOR_TOTAL_TITULOS" length="15" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="Filler" length="8" />
                        </GroupOfFields>
                        </Record>
                 */
                rodape(
                        fcodigoRegistro().value(9),
                        fcodigoRetorno(),
                        fzero().length(2),
                        fbranco().length(3),
                        fzero().length(10),
                        fquantidadeRegistros().length(8),
                        fvalorTotalRegistros().length(8),
                        fzero().length(8)
                )
        );
        return flatfileLayout;
    }

    public TagLayout layoutBancoSantander() {
        TagLayout flatfileLayout = flatfile(
                /*
                <layout>
                <name>Arquivo-Febraban_CNAB400</name>
                <version>Version 00</version>
                <description>
                Layout padrão do Febraban
                </description>
                </layout>
                 */
                layout(
                        nome("Arquivo-Febraban_CNAB400"),
                        descricao("Layout padrão do Febraban"),
                        versao("01"),
                        banco(BancosSuportados.BANCO_SANTANDER.create()),
                        cnab(CNAB.CNAB_400),
                        servico(CNABServico.COBRANCA_REMESSA)
                ),
                /*
                        <GroupOfRecords>
                        <Record name="cabecalho" description="Protocolo de comunicação">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1" value="0" />
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="AGENCIA" length="4" type="INTEGER" padding="ZERO_LEFT" />
                        <Field name="DATA_ARQUIVO" length="6" type="DATE" format="DATE_DDMMYY" />
                 */
                cabecalho(
                        fcodigoRegistro().value(0),
                        fcodigoRetorno(),
                        fagencia().length(4),
                        fconta().length(7),
                        fdataGeracao()
                ),
                titulo(
                        fcodigoRegistro().value(7)
                ),
                /*
                        <Record name="TRAILLER">
                        <GroupOfFields>
                        <IdType name="CODIGO_REGISTRO" length="1" position="1"  value="9"/>
                        <Field name="CODIGO_RETORNO" length="1" />
                        <Field name="Filler" length="2" />
                        <Field name="CODIGO_BANCO" length="3" />
                        <Field name="Filler" length="10" />
                        <Field name="QUANTIDADE_TITULOS" length="8" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="VALOR_TOTAL_TITULOS" length="15" type="BIGDECIMAL" format="DECIMAL_DD" />
                        <Field name="Filler" length="8" />
                        </GroupOfFields>
                        </Record>
                 */
                rodape(
                        fcodigoRegistro().value(9),
                        fcodigoRetorno(),
                        fzero().length(2),
                        fbranco().length(3),
                        fzero().length(10),
                        fquantidadeRegistros().length(8),
                        fvalorTotalRegistros().length(8),
                        fzero().length(8)
                )
        );
        return flatfileLayout;
    }

    private Object setVal(String horaGeracao, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
