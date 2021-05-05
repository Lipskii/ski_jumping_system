import React, {useState} from 'react';
import {Table, Input, InputNumber, Popconfirm, Form, Typography} from 'antd';
import axios from "axios";

const prepareData = (results) => {
    let data = []
    for (const result of results) {
        data.push({
            key: result.id,
            ...result
        })
    }
    return data
}

const EditableCell = ({
                          editing,
                          dataIndex,
                          title,
                          inputType,
                          record,
                          index,
                          children,
                          ...restProps
                      }) => {
    const inputNode = inputType === 'number' ? <InputNumber/> : <Input/>;
    return (
        <td {...restProps}>
            {editing ? (
                <Form.Item
                    name={dataIndex}
                    style={{
                        margin: 0,
                    }}
                    rules={[
                        {
                           // required: true,
                            type: "number",
                            message: `Should be a number!`,
                        },
                    ]}
                >
                    {inputNode}
                </Form.Item>
            ) : (
                children
            )}
        </td>
    );
};

const EditableTable = (props) => {

    const [form] = Form.useForm();
    const [data, setData] = useState([]);
    const [editingKey, setEditingKey] = useState('');

    if (!data.length > 0) {
        setData(prepareData(props.competition.results))
    }

    const columns = [
        {
            title: 'skiJumper',
            dataIndex: 'skiJumper',
            fixed: 'left',
            width: '25%',
            editable: false,
            render: skiJumper => <div>{skiJumper.person.firstName} {skiJumper.person.lastName}</div>
        },
        {
            title: 'Rank',
            dataIndex: 'totalRank',
            //    fixed: 'left',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round distance',
            dataIndex: 'firstRoundDistance',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round distance points',
            dataIndex: 'firstRoundDistancePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round gate',
            dataIndex: 'firstRoundGate',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round gate points',
            dataIndex: 'firstRoundGatePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round speed',
            dataIndex: 'firstRoundSpeed',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge A score',
            dataIndex: 'firstRoundJudgeA',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge B score',
            dataIndex: 'firstRoundJudgeB',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge C score',
            dataIndex: 'firstRoundJudgeC',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge D score',
            dataIndex: 'firstRoundJudgeD',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge E score',
            dataIndex: 'firstRoundJudgeE',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge SC score',
            dataIndex: 'firstRoundJudgeSC',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round judge total points',
            dataIndex: 'firstRoundJudgePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round rank',
            dataIndex: 'firstRoundRank',
            width: '15%',
            editable: true,
        },
        {
            title: '1. round total',
            dataIndex: 'firstRoundTotal',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round distance',
            dataIndex: 'secondRoundDistance',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round distance points',
            dataIndex: 'secondRoundDistancePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round gate',
            dataIndex: 'secondRoundGate',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round gate points',
            dataIndex: 'secondRoundGatePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round speed',
            dataIndex: 'secondRoundSpeed',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge A score',
            dataIndex: 'secondRoundJudgeA',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge B score',
            dataIndex: 'secondRoundJudgeB',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge C score',
            dataIndex: 'secondRoundJudgeC',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge D score',
            dataIndex: 'secondRoundJudgeD',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge E score',
            dataIndex: 'secondRoundJudgeE',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge SC score',
            dataIndex: 'secondRoundJudgeSC',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round judge total points',
            dataIndex: 'secondRoundJudgePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round rank',
            dataIndex: 'secondRoundRank',
            width: '15%',
            editable: true,
        },
        {
            title: '2. round total',
            dataIndex: 'secondRoundTotal',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round distance',
            dataIndex: 'thirdRoundDistance',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round distance points',
            dataIndex: 'thirdRoundDistancePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round gate',
            dataIndex: 'thirdRoundGate',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round gate points',
            dataIndex: 'thirdRoundGatePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round speed',
            dataIndex: 'thirdRoundSpeed',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge A score',
            dataIndex: 'thirdRoundJudgeA',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge B score',
            dataIndex: 'thirdRoundJudgeB',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge C score',
            dataIndex: 'thirdRoundJudgeC',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge D score',
            dataIndex: 'thirdRoundJudgeD',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge E score',
            dataIndex: 'thirdRoundJudgeE',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge SC score',
            dataIndex: 'thirdRoundJudgeSC',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round judge total points',
            dataIndex: 'thirdRoundJudgePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round rank',
            dataIndex: 'thirdRoundRank',
            width: '15%',
            editable: true,
        },
        {
            title: '3. round total',
            dataIndex: 'thirdRoundTotal',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round distance',
            dataIndex: 'fourthRoundDistance',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round distance points',
            dataIndex: 'fourthRoundDistancePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round gate',
            dataIndex: 'fourthRoundGate',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round gate points',
            dataIndex: 'fourthRoundGatePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round speed',
            dataIndex: 'fourthRoundSpeed',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge A score',
            dataIndex: 'fourthRoundJudgeA',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge B score',
            dataIndex: 'fourthRoundJudgeB',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge C score',
            dataIndex: 'fourthRoundJudgeC',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge D score',
            dataIndex: 'fourthRoundJudgeD',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge E score',
            dataIndex: 'fourthRoundJudgeE',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge SC score',
            dataIndex: 'fourthRoundJudgeSC',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round judge total points',
            dataIndex: 'fourthRoundJudgePoints',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round rank',
            dataIndex: 'fourthRoundRank',
            width: '15%',
            editable: true,
        },
        {
            title: '4. round total',
            dataIndex: 'fourthRoundTotal',
            width: '15%',
            editable: true,
        },
        {
            title: 'Total points',
            dataIndex: 'totalPoints',
            width: '15%',
            editable: true,
        },
        {
            title: 'operation',
            dataIndex: 'operation',
            fixed: 'right',
            render: (_, record) => {
                const editable = isEditing(record);
                return editable ? (
                    <span>
            <a
                href="javascript:;"
                onClick={() => save(record.key)}
                style={{
                    marginRight: 8,
                }}
            >
              Save
            </a>
            <Popconfirm title="Sure to cancel?" onConfirm={cancel}>
              <a>Cancel</a>
            </Popconfirm>
          </span>
                ) : (
                    <Typography.Link disabled={editingKey !== ''} onClick={() => edit(record)}>
                        Edit
                    </Typography.Link>
                );
            },
        },
    ];

    const isEditing = (record) => record.key === editingKey;

    const edit = (record) => {
        form.setFieldsValue({
            ...record,
        });
        setEditingKey(record.key);
    };


    const cancel = () => {
        setEditingKey('');
    };


    const save = async (key) => {
        try {
            let row = await form.validateFields();
            const newData = [...data];
            const index = newData.findIndex((item) => key === item.key);

            if (index > -1) {
                const item = newData[index];
                newData.splice(index, 1, {...item, ...row});
                row["competition"] = props.competition
                row["skiJumper"] = item.skiJumper
                console.log(row)
                axios.put("/api/results/" + item.id, {...row})
                    .then(res => {
                        console.log(res.data)
                        setData(newData);
                        setEditingKey('');
                    })
                    .catch(e => console.log(e))
            }
        } catch (errInfo) {
            console.log('Validate Failed:', errInfo);
        }
    };


    const mergedColumns = columns.map((col) => {
        if (!col.editable) {
            return col;
        }

        return {
            ...col,
            onCell: (record) => ({
                record,
                inputType: 'number',
                dataIndex: col.dataIndex,
                title: col.title,
                editing: isEditing(record),
            }),
        };
    });

    return (
        <Form form={form} component={false}>
            <Table
                components={{
                    body: {
                        cell: EditableCell,
                    },
                }}
                bordered
                dataSource={data}
                columns={mergedColumns}
                rowClassName="editable-row"
                pagination={{
                    onChange: cancel,
                }}
            />
        </Form>
    );
};

export default EditableTable