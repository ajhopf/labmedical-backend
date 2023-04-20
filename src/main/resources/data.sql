/*-------------------Médicos---------------------------*/
INSERT INTO
    MEDICOS(CPF,
            DOB,
            EMAIL,
            ESTADO_CIVIL,
            GENERO,
            NATURALIDADE,
            NOME_COMPLETO,
            RG,
            TELEFONE,
            CRM,
            ESPECIALIZACAO,
            SENHA)
VALUES
    ('694.213.348-50',
     '06/04/1966',
     'brendarosamelo@unitau.br',
     'casado',
     'feminino',
     'Florianópolis',
     'Brenda Rosa Manuela Melo',
     '368923988',
     '(42) 98950-7626',
     '12345',
     'ortopedista',
     'branda1234');

INSERT INTO
    MEDICOS(CPF,
            DOB,
            EMAIL,
            ESTADO_CIVIL,
            GENERO,
            NATURALIDADE,
            NOME_COMPLETO,
            RG,
            TELEFONE,
            CRM,
            ESPECIALIZACAO,
            SENHA)
VALUES
    ('022.567.470-00',
     '14/03/1992',
     'andre.hopf@hotmail.com',
     'solteiro',
     'masculino',
     'Porto Alegre',
     'André Jaques Hopf',
     '8098963161',
     '(48) 999030959',
     '12345',
     'neurologista',
     'andre1234');

/*-------------------Endereços---------------------------*/

INSERT INTO
    ENDERECOS(
    BAIRRO,
    CEP,
    CIDADE,
    COMPLEMENTO,
    ESTADO,
    LOGRADOURO,
    NUMERO,
    PONTO_REFERENCIA
)
VALUES(
       'Campeche',
       '88063-431',
       'Florianópolis',
       null,
       'SC',
       'Servidão Arara Azul',
       '25',
       null
      );

INSERT INTO
    ENDERECOS(
    BAIRRO,
    CEP,
    CIDADE,
    COMPLEMENTO,
    ESTADO,
    LOGRADOURO,
    NUMERO,
    PONTO_REFERENCIA
)
VALUES(
          'Residencial Padre Lothar',
          '78715-881',
          'Rondonópolis',
          31,
          'MT',
          'Rua Sabará',
          25,
          null
      );

INSERT INTO
    ENDERECOS(
    BAIRRO,
    CEP,
    CIDADE,
    COMPLEMENTO,
    ESTADO,
    LOGRADOURO,
    NUMERO,
    PONTO_REFERENCIA
)
VALUES(
          'Scharlau',
          '93125-350',
          'São Leopoldo',
          null,
          'RS',
          'Rua Augusto Berger',
          '198',
          'Próximo ao mercado Dimas'
      );

INSERT INTO
    ENDERECOS(
    BAIRRO,
    CEP,
    CIDADE,
    COMPLEMENTO,
    ESTADO,
    LOGRADOURO,
    NUMERO,
    PONTO_REFERENCIA
)
VALUES(
          'Carianos',
          '88047-618',
          'Florianópolis',
          'casa 1',
          'SC',
          'Rua Recanto dos Girassóis',
          301,
          null
      );

/*-------------------Pacientes---------------------------*/

INSERT INTO
    PACIENTES(
    CPF,
    DOB,
    EMAIL,
    ESTADO_CIVIL,
    GENERO,
    NATURALIDADE,
    NOME_COMPLETO,
    RG,
    TELEFONE,
    ALERGIAS,
    CONTATO_DE_EMERGENCIA,
    CONVENIO,
    CUIDADOS_ESPECIFICOS,
    NUMERO_CONVENIO,
    VALIDADE_CONVENIO,
    ENDERECO_ID)
VALUES (
        '459.608.769-57',
        '01/04/1954',
        'marcio-dasneves87@dyna.com.br',
        'solteiro',
        'viuvo',
        'Dourados',
        'Márcio Samuel das Neves',
        '100715011',
        '(67) 99386-1766',
        'formiga, abacaxi',
        'Priscila Milena - (67) 2515-2686',
        'UNIMED',
        null,
        '12345676',
        '12/12/2030',
        1
       );

INSERT INTO
    PACIENTES(
    CPF,
    DOB,
    EMAIL,
    ESTADO_CIVIL,
    GENERO,
    NATURALIDADE,
    NOME_COMPLETO,
    RG,
    TELEFONE,
    ALERGIAS,
    CONTATO_DE_EMERGENCIA,
    CONVENIO,
    CUIDADOS_ESPECIFICOS,
    NUMERO_CONVENIO,
    VALIDADE_CONVENIO,
    ENDERECO_ID)
VALUES (
    '300.160.272-48',
    '13/01/1995',
    'breno.tomas.araujo@ruilacos.com.br',
    'casado',
    'masculino',
    'Araguari',
    'Breno Tomás Araújo',
    '230739581',
    '(34) 98889-1181',
    null,
    'Brenda Marina Valentina - (34) 2971-3504',
    null,
    null,
    null,
    null,
    4
    );

/*---------------Consultas------------------*/
INSERT INTO
    CONSULTAS(
    DESCRICAO_DO_PROBLEMA,
    DOSAGENS_E_PRECAUCOES,
    HORA_E_DATA,
    MEDICACAO_RECEITADA,
    MOTIVO_DA_CONSULTA,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'Tremores, lentidão, caminhar arrastando os pés, postura inclinada para frente. Suspeita de Parkinson, encaminho para ressonância magnética.',
          'Boa alimentação, atividade física moderada',
          '17/04/2023 09:51:16',
          'Suplemento vitamínico',
          'Fraqueza e tremores',
          2,
          1
      );

INSERT INTO
    CONSULTAS(
    DESCRICAO_DO_PROBLEMA,
    DOSAGENS_E_PRECAUCOES,
    HORA_E_DATA,
    MEDICACAO_RECEITADA,
    MOTIVO_DA_CONSULTA,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
       'Quadro álgico no punho esquerdo durante movimento de extensão, eva 7; Início após queda de bicicleta',
       'Suspeita de fratura. Encaminho para raio-x.',
       '18/04/2023 11:32:57',
       'Ibuprofeno',
       'Dor no punho E',
       1,
       2
      );

INSERT INTO
    CONSULTAS(
    DESCRICAO_DO_PROBLEMA,
    DOSAGENS_E_PRECAUCOES,
    HORA_E_DATA,
    MEDICACAO_RECEITADA,
    MOTIVO_DA_CONSULTA,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'Retorno após raio-x. Fratura do rádio distal no MSE.',
          'Repouso e boa alimentação, cuidado com o gesso. Analgésico se necessário, 3 a 4 vezes ao dia. Encaminho para setor de cirurgia.',
          '18/04/2023 16:21:37',
          'Dorflex.',
          'Dor no punho E - retorno',
          1,
          2
      );

INSERT INTO
    CONSULTAS(
    DESCRICAO_DO_PROBLEMA,
    DOSAGENS_E_PRECAUCOES,
    HORA_E_DATA,
    MEDICACAO_RECEITADA,
    MOTIVO_DA_CONSULTA,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'Após avaliação da ressonância magnética associado a apresentação clínica chegamos ao diagnóstico de Parkinson.',
          'Levodopa 1x por dia (250mg). Praticar atividades físicas regulares e moderadas, para estimular os movimentos. Recomendo fisioterapia, fonoaudiologia e suporte psicológico. ',
          '20/04/2023 07:11:56',
          'Suplemento vitamínico, Levodopa',
          'Fraqueza e tremores - retorno',
          2,
          1
      );

/*------------------------------exames-------------------------------------*/

INSERT INTO
    EXAMES(
    ARQUIVO_DE_EXAME,
    HORA_E_DATA,
    lABORATORIO,
    NOME_DO_EXAME,
    RESULTADO_DO_EXAME,
    TIPO_DO_EXAME,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
       'https://drmarciosilveira.com/wp-content/uploads/2019/01/caso1b.jpg',
       '18/04/2023 13:01:33',
       'Sonitec',
       'Raio-x',
       'Fratura do rádio distal',
       'Raio-x de punho, AP e Perfil',
       1,
       2
      );

INSERT INTO
    EXAMES(
    ARQUIVO_DE_EXAME,
    HORA_E_DATA,
    lABORATORIO,
    NOME_DO_EXAME,
    RESULTADO_DO_EXAME,
    TIPO_DO_EXAME,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'https://ogimg.infoglobo.com.br/in/21575034-b06-67d/FT1086A/ressonancia.jpg',
          '19/04/2023 06:17:03',
          'Clínica Imagem',
          'Ressonância Magnética',
          'Lesões sugestivas de doença de parkinson',
          'Ressonância magnética funcional',
          2,
          1
      );


INSERT INTO
    EXAMES(
    ARQUIVO_DE_EXAME,
    HORA_E_DATA,
    lABORATORIO,
    NOME_DO_EXAME,
    RESULTADO_DO_EXAME,
    TIPO_DO_EXAME,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'https://www.tuasaude.com/como-entender-o-exame-de-sangue/',
          '20/04/2023 14:37:43',
          'Santa Luzia',
          'Hemograma',
          'Indicadores dentro da faixa de normalidade',
          'Hemograma completo, VHS, CPK, TSH, PCR, exames para o fígado e o PSA',
          2,
          1
      );

INSERT INTO
    EXAMES(
    ARQUIVO_DE_EXAME,
    HORA_E_DATA,
    lABORATORIO,
    NOME_DO_EXAME,
    RESULTADO_DO_EXAME,
    TIPO_DO_EXAME,
    MEDICO_ID,
    PACIENTE_ID)
VALUES(
          'https://orthoinfo.aaos.org/globalassets/figures/a00753f04.jpg',
          '23/04/2023 20:37:13',
          'Sonitec',
          'Raio-x',
          'Bom posicionamento da placa e do parafuso após cirurgia de fixação do rádio distal.',
          'Raio-x de punho, AP e Perfil',
          1,
          2
      );








