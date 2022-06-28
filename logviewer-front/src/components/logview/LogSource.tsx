import { List, ListItem, TextField } from "@mui/material";
import React from "react";
import "./LogView.css"


interface LogSourceProps {
    title: string;
    content: string;
  }

interface LogSourceQuery {
    query: string;
}

export default function LogSource(props: LogSourceProps) {

    const [values, setValues] = React.useState<LogSourceQuery>({
        query: '',
      });

    const handleQuery =
        (prop: any) => (event: React.ChangeEvent<HTMLInputElement>) => {
            setValues({ ...values, [prop]: event.target.value });
            // Make query to log file with respective query
        };
  
    return (
      <div className='log-source'>
          <List>
            <ListItem className="source-results">{props.content}</ListItem>
          </List>
      </div>
    );
  }