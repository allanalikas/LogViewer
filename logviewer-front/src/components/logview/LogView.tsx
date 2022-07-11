import { Box, Tab, Tabs, TextField, Typography } from '@mui/material';
import * as React from 'react';
import { UserContext } from '../../context/user-context';
import LogSource from './LogSource';
import "./LogView.css"

interface LogSourceQuery {
  query: string;
}

interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

function TabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;
  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ width: 1 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

export default function LogView() {

  const [logSources, setLogSources] = React.useState([
    {id: 1, title: 'Hello World', content: 'Welcome to learning React!'},
    {id: 2, title: 'Hello Me', content: 'Welcome to learning React2!'},
  ]);
  const [index, setIndex] = React.useState(0);
  const [values, setValues] = React.useState<LogSourceQuery>({
    query: '',
  });

  const handleQuery =
    (prop: any) => (event: React.ChangeEvent<HTMLInputElement>) => {
        setValues({ ...values, [prop]: event.target.value });
        // Make query to log file with respective query
    };

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setIndex(newValue);
  };

  function allyProps(index: number) {
    return {
      id: `simple-tab-${index}`,
      'aria-controls': `simple-tabpanel-${index}`,
    };
  }

  const content = logSources.map((source) =>
    {
      return <LogSource
        key={source.id}
        title={source.title} 
        content={source.content} />;
    }
  );

  const tabs = logSources.map((source, index) => {
    return <Tab label={source.title} {...allyProps(index)}/>
  })

  const tabPanels = logSources.map((source, idx) => {
    return <TabPanel value={index} index={idx}>{content[idx]}</TabPanel>
  })

  return (
    <div className='main-div'>
        <UserContext.Consumer>
          {({username}) => (
            <h1>{username}</h1>
          )}
        </UserContext.Consumer>
        <div className='logview-div'>
          <div className='multi-query-container'>
            <TextField fullWidth sx={{ m: 1 }}
                        id="multi-query" 
                        label="Query for all files" 
                        variant="outlined"
                        value={values.query}
                        onChange={handleQuery("query")} />
          </div>

          <Box className='results' sx={{ width: '100%' }}>
            <div className='tabs'>
            <Tabs value={index} onChange={handleChange} aria-label="basic tabs example">
              {tabs}
            </Tabs>
            </div>
            <div className='tabpanels'>
              {tabPanels}
            </div>
          </Box>
        </div>
    </div>
  );
}